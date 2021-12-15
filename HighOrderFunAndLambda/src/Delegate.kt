import javax.management.ObjectInstance
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

//委托属性
class Delegate {
    operator fun getValue(thisRef: Any?,property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}
class Example {
    var p: String by Delegate()
}

//延迟属性Lazy
//默认情况下，对于 lazy 属性的求值是同步锁的（synchronized）：
// 该值只在一个线程中计算，并且所有线程会看到相同的值。
// 如果初始化委托的同步锁不是必需的，这样多个线程可以同时执行，那么将 LazyThreadSafetyMode.PUBLICATION 作为参数传递给 lazy() 函数。
// 而如果你确定初始化将总是发生在与属性使用位于相同的线程， 那么可以使用 LazyThreadSafetyMode.NONE 模式：它不会有任何线程安全的保证以及相关的开销。
val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}

//可观察属性Observable
class User {
    var name: String by Delegates.observable("<no name>") {
        prop, old, new ->
        println("$old -> $new")
    }
}

//委托给另一个属性,应在委托名称中使用恰当的 :: 限定符，例如，this::delegate 或 MyClass::delegate。
var topLevelInt: Int = 0

class ClassWithDelegate(val anotherClassInt: Int)
class MyClass(var memberInt: Int, val anotherClassInstance: ClassWithDelegate) {
    var delegatedToMember: Int by this::memberInt
    var delegatedToTopLevel: Int by ::topLevelInt
    val delegatedToAnotherClass: Int by anotherClassInstance::anotherClassInt
}
var MyClass.extDelegated: Int by ::topLevelInt


//以一种向后兼容的方式重命名一个属性的时候：
// 引入一个新的属性、 使用 @Deprecated 注解来注解旧的属性、并委托其实现
class MyClass2 {
    var newName: Int = 0
    @Deprecated("Use 'newName' instead", ReplaceWith("newName"))
    var oldName: Int by this::newName
}

//将属性存储在映射中
class User2(val map: Map<String,Any?>){
    val name: String by map
    val age: Int by map
}

fun main() {
    val e = Example()
    println(e.p)
    e.p = "NEW"

    //延迟属性Lazy
    println(lazyValue)

    //可观察属性
    val user = User()
    user.name = "first"
    user.name = "second"

    //向后兼容重命名
    val myClass2 = MyClass2()
    // 通知：'oldName: Int' is deprecated.
    // Use 'newName' instead
    myClass2.oldName = 42
    println(myClass2.newName)

    //将属性存储在映射中
    val user2 = User2(mapOf(
        "name" to "John Doe",
        "age" to 25
    ))
    //委托属性从映射中取值
    println(user2.name)
    println(user2.age)
    println(user2.map)
}
