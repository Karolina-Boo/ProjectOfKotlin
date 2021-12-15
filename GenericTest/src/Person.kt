open class Person
class Student: Person()
class Teacher: Person()

class SimpleData<out T> {} //泛型协变
class SimpleData1<in T> {} //泛型逆变
class SimpleData2<T> {}    //泛型不变
class KotlinGeneric<out T: Number> {} //无界通配符

fun main() {
    //泛型协变：<out T> 类似于 Java 的 <? extends Bound>，
    // 它限定的类型是当前上边界类或者其子类，如果是接口的话就是当前上边界接口或者实现类，
    // 协变的泛型变量只读，不可以写，可以添加 null ，但是没意义
    val person: Person = Student()
    val personGeneric: SimpleData<Person> = SimpleData<Student>()
    val list1: ArrayList<out Person> = ArrayList<Student>()

    //泛型逆变：<in T> 类似于 Java 的 <? super Bound>，
    // 它限定的类型是当前下边界类或者其父类，如果是接口的话就是当前下边界接口或者其父接口，
    // 逆变的泛型变量只能写，不建议读
    val person1: Person = Student()
    val personGeneric1: SimpleData1<Student> = SimpleData1<Person>()
    val list2: ArrayList<in Person> = ArrayList<Any>()

    //泛型不变：与java相同
    val person2: Person = Student()
    //编译器不允许
//    val personGeneric2: SimpleData2<Person> = SimpleData2<Student>()

    //无界通配符：Kotlin 使用 <*> 这种语法结构来表示无界通配符，它等价于 <out Any>，
    // 类似于 Java 中的 <?>，在定义一个类的时候你如果使用<out T : Number> ，
    // 那么 * 就相当于 <out Number>
    val noBound: KotlinGeneric<*> = KotlinGeneric<Int>()

    //根据协变规则，编译器不允许这么写
//    val noBound: KotlinGeneric<*> = KotlinGeneric<Any>()

}