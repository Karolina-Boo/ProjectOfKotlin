interface Drinkable {
    fun drink(): String
    val LATTE: String
}

class Cafe {
    companion object Beverage: Drinkable {
        override fun drink() = "i like coffee"
        override val LATTE = "latte"
        fun bestBeverage() = LATTE
    }
}

class Cafe1 {
    object Beverage {
        const val LATTE = "latte"
    }

    fun bestBeverage() = Beverage.LATTE
}

fun main() {
    println(Cafe.LATTE)
    println(Cafe1.Beverage.LATTE)
}