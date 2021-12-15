
/**
 * Kotlin的SAM转换
 * SAM构造方法
 */

fun main() {
    //使用高阶函数
//    SAMTest.buyBike {money:Double -> println("buyBike: $money")}
//    SAMTest.buyCar {money:Double -> println("buyCar: $money")}
    //方案一： 匿名类对象(有方法声明)
    buySkater(object : IBuy {
        override fun onBuy(money: Double) {
            println("buySkater: $money")
        }
    })
    //方案二： SAM构造方法（省略参数列表）
    buySkater(IBuy {
        println("buySkater: $it")
    })
    //方案三： SAM构造方法（省略函数名）
    buySkater({
        println("buySkater: $it")
    })
    //方案四： SAM构造方法（使用高阶函数，只包含主函数体）
    buySkater {
        println("buySkater: $it")
    }
}

fun buySkater(buy: IBuy) {
    buy.onBuy(5000.00)
}
