class FunInstantiation {
}

fun main(){
    //带与不带接收者的函数类型非字面值可以互换，其中接收者可以替代第一个参数，反之亦然。例如，(A, B) -> C 类型的值可以传给或赋值给期待 A.(B) -> C 的地方，反之亦然：
    val repeatFun: String.(Int) -> String = {times -> this.repeat(times)}
    val twoParameters: (String, Int) -> String = repeatFun

    fun runTransformation(f: (String, Int) -> String): String {
        return f("hello", 3)
    }
    val result = runTransformation(twoParameters)
    println("result = $result")
}