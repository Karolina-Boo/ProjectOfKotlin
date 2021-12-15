/**
 * 接口定义
 */
interface Demo1Interface {
    //定义的方法
    fun fun1()
}

interface Demo2Interface {
    /**
     * 定义一个无参数无返回值的方法
     */
    fun fun1()

    /**
     * 定义一个有参数的方法
     */
    fun fun2(num: Int)

    /**
     * 定义一个有参数有返回值的方法
     */
    fun fun3(num: Int) : Int

    /**
     * 定义一个无参数有返回值的方法，因为实现了，所以可以不重写
     */
    fun fun4() : String {
        return "fun4"
    }
}

interface Demo3Interface {
    val num1: Int
    val num2: Int

    //val num3: Int = 3 这种方式不提供，会直接报错
    val num3: Int
    get() = 3

    val num4: Int
}

interface Demo4InterfaceOne {
    fun fun1() {
        println("我是Demo4InterfaceOne中的fun1()")
    }
    fun fun2() {
        println("我是Demo4InterfaceOne中的fun2()")
    }
}

interface Demo4InterfaceTwo {
    fun fun1() {
        println("我是Demo4InterfaceTwo中的fun1()")
    }

    fun fun2() {
        println("我是Demo4InterfaceTwo中的fun2()")
    }
}

/**
 * 接口的实现类
 */
class Demo1 : Demo1Interface {
    override fun fun1() {
        println("我是接口中的fun1方法")
    }
}

class Demo2 : Demo2Interface {
    override fun fun1() {
        println("我是fun1()方法")
    }

    override fun fun2(num: Int) {
        println("我是fun2()方法，我的参数是$num")
    }

    override fun fun3(num: Int): Int {
        println("我是fun3()方法，我的参数是$num, 并且返回一个Int类型的值")
        return num + 3
    }

    override fun fun4(): String {
        println("我是fun4()方法，并且返回一个String类型的值")
        return super.fun4()
    }
}

class Demo3(override val num1: Int, override val num2: Int) : Demo3Interface {
    fun sum() : Int {
        return num1 + num2
    }
    //提供访问器实现
    override val num3: Int
        get() = super.num3

    //手动赋值
    override var num4: Int = 4

    fun result() : Int {
        return num3 + num4
    }
}

class Demo4 : Demo4InterfaceOne,Demo4InterfaceTwo {
    override fun fun1() {
        super<Demo4InterfaceOne>.fun1()
        super<Demo4InterfaceTwo>.fun1()
    }

    override fun fun2() {
        super<Demo4InterfaceOne>.fun2()
        super<Demo4InterfaceTwo>.fun2()
    }

}

fun main() {
    //类的初始化
//    var demo = Demo1()
//    demo.fun1()
//    var demo = Demo2()
//    demo.fun1()
//    demo.fun2(5)
//    println(demo.fun3(10))
//    println(demo.fun4())
//    var demo = Demo3(1,2)
//    println(demo.sum())
//
//    println(demo.result())
//    //在这里也可以改变接口属性的值
//    demo.num4 = 10
//    println(demo.result())
    val demo = Demo4()
    demo.fun1()
    demo.fun2()
}
