const val constVariable = ""    //Top-Level级别
val nonConstVariable = ""

// object对象
object obj {
    const val constVariableObj = ""
    val nonConstVariableObj = ""
}

//伴生对象也是object
class ConstTest {
    companion object {
        const val constVariableCompanion = ""
        val nonConstVariableCompanion = ""
    }
}

fun main() {
    //kotlin中，没有const修饰都是直接引用，有const和没有const的引用方式区别不大
    println("**********Top-Level*********")
    println(constVariable)
    println(nonConstVariable)

    println("**********Object**********")
    println(obj.constVariableObj)
    println(obj.nonConstVariableObj)

    println("**********Companion-Object**********")
    println(ConstTest.constVariableCompanion)
    println(ConstTest.nonConstVariableCompanion)
}