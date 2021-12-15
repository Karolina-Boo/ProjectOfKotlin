//情况1：单个边界
class MyClass1<T: Number> {
    var data: T? = null
    fun <T: Number> method(params: T) {

    }
}

//情况2：多个边界使用where关键字
open class Animal
interface Food
interface Food2

class MyClass2<T> where T: Animal, T: Food, T: Food2 {
    fun <T> method(params: T) where T: Animal, T: Food, T: Food2 {}
}

inline fun <reified T> getGenericType() = T::class.java

fun main() {
    //泛型实化，泛型实化在 Java 中是不存在的，Kotlin 中之所以能实现泛型实化，
    // 是因为使用的内联函数会对代码进行替换，那么在内联函数中使用泛型，最终也会使用实际的类型进行替换
    val result1 = getGenericType<String>()
    val result2 = getGenericType<Number>()
    println(result1)
    println(result2)
}