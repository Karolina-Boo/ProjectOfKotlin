//1. 定义一个泛型类
class MyClass<T> {
//    fun method(params: T) {
//
//    }

    //2. 定义一个泛型方法
    fun <T> method(params: T) {

    }
}

//3. 定义一个泛型接口
interface MyInterface<T> {
    fun interfaceMethod(params: T)
}
//泛型调用
fun main() {
    val myClass = MyClass<Int>()
    myClass.method(12)
}
