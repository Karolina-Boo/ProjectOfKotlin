class Box<T>(t: T) {
    var value = t
}

fun main() {
    val box: Box<Int> = Box<Int>(1)
    println(box.value)
    //省略类型参数
    val box1 = Box(1)
    println(box1.value)
}