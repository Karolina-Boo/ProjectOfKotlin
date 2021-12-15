/**
 * 委托模式（delegation pattern）是软件设计模式中的一项基本技巧。在委托模式中,
 * 有两个对象参与处理同一个请求，接受请求的对象将请求委托给另一个对象来处理。
 */
class People {
    fun sayHello() {
        println("Hello World!")
    }
}

class Student {
    fun sayHello() {
        People().sayHello()
    }
}

fun main() {
    Student().sayHello()
}