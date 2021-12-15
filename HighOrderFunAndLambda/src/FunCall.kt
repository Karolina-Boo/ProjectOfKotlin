class FunCall {
}

fun main() {
    //函数类型的值可以通过其 invoke(……) 操作符调用：f.invoke(x) 或者直接 f(x)
    //如果该值具有接收者类型，那么应该将接收者对象作为第一个参数传递。 调用带有接收者的函数类型值的另一个方式是在其前面加上接收者对象， 就好比该值是一个扩展函数：1.foo(2)
    val stringPlus: (String, String) -> String = String::plus
    val intPlus: Int.(Int) -> Int = Int::plus

    println(stringPlus.invoke("<-","->"))
    println(stringPlus("Hello, ", "world!"))

    println(intPlus.invoke(1,1))
    println(intPlus(1,2))
    println(2.intPlus(3))//类扩展调用
}