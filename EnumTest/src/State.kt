import java.awt.Color

enum class State {
    /*
         NORMAL: 正常
         NO_DATA: 数据为空
         NO_INTERNET: 网络未连接
         ERROR: 错误
         OTHER: 其他
     */
    NORMAL,NO_DATA,NO_INTERNET,ERROR,OTHER
}

fun main() {
    ConsoleColor.BLACK.print()
    //访问枚举变量属性
    println("name = " + ConsoleColor.RED.name + "\tordinal = " + ConsoleColor.RED.ordinal)
    println("name = " + ConsoleColor.WHITE.name + "\tordinal = " + ConsoleColor.WHITE.ordinal)
    println("name = " + ConsoleColor.BLACK.name + "\tordinal = " + ConsoleColor.BLACK.ordinal)
    println("name = " + ConsoleColor.GREEN.name + "\tordinal = " + ConsoleColor.GREEN.ordinal)
    //使用enumValues<T>()和 enumValueOf<T>()函数以泛型的方式访问枚举类中的常量。
    println(enumValues<ConsoleColor>().joinToString { it.name })
    println(enumValueOf<ConsoleColor>("RED"))
    //使用valueOf()和values()检测指定的名称与枚举类中定义的任何枚举常量是否匹配。
    println(ConsoleColor.valueOf("RED"))
    println(ConsoleColor.values()[0])
    println(ConsoleColor.values()[1])
    println(ConsoleColor.values()[2])
    println(ConsoleColor.values()[3])
}

enum class ConsoleColor(var argb: Int){
    RED(0xff0000) {
        override fun print() {
            println("我是枚举常量 RED")
        }
    },
    WHITE(0xffffff) {
        override fun print() {
            println("我是枚举常量 WHITE")
        }
    },
    BLACK(0x000000) {
        override fun print() {
            println("我是枚举常量 BLACK")
        }
    },
    GREEN(0x00ff00) {
        override fun print() {
            println("我是枚举常量 GREEN")
        }
    };

    abstract fun print()
}