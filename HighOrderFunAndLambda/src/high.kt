typealias SumAlias = (Int,Int) -> Int

inline fun printSum(a: Int, b: Int, block: SumAlias) { //没有设置inline关键字
    println(block.invoke(a,b))
}

fun main(args: Array<String>) {
    printSum(4,5) {a,b -> a + b}
}