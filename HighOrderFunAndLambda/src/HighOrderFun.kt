class HighOrderFun {

}

fun main() {
    val items = listOf(1, 2, 3, 4, 5)
    //Lambda表达式是花括号括起来的代码块
    //如果一个lambda表达式有参数，前面是参数，后跟“->”
    //lambda表达式中的最后一个表达式是返回值
    items.fold(0, { acc: Int, i: Int ->
        print("acc = $acc, i = $i, ")
        val result = acc + i
        println("result = $result")
        result
    })
    //lambda表达式的参数类型如果可以推断出来，可以不写
    val joinedToString = items.fold("Elements:", {acc, i -> acc + " " + i  })
    //函数引用也可以用于高阶函数调用
    val product = items.fold(1, Int::times)
    println("joinToString = $joinedToString") //
    println("product = $product")


}
