typealias Sum = (Int, Int, Int) -> Int

fun main(args: Array<String>) {
    val sum: Sum = {a,b,c -> a+b+c}
    println(sum.invoke(1,2,3))
}


