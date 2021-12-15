//class Person {
    //幕后字段的基本用法
//    var name: String = "Paul"
//        set(value) {
//            field = value
//        }
//        get() = field

    //自定义getter和setter
//    get() = "i am getter, name is Jake"
//}

//fun main() {
//    var person = Person()

//第一次打印name的值
//    println("name: ${person.name}")
//    //重新给name赋值
//    person.name = "Jake"
//    //打印name的新值
//    println("name: ${person.name}")

//写name属性
//    person.name = "hi, this is new value"
//    println("打印结果：${person.name}")
//}


/**
 * 幕后字段的进阶用法:
 * 用于让一个属性在不同的条件下有不同的值
 */
class Person (var gender: Gender) {
    var name: String = ""
    set(value) {
        field = when(gender) {
            Gender.MALE -> "Jake.$value"
            Gender.FEMALE -> "Rose.$value"
        }
    }
}

enum class Gender {
    MALE,
    FEMALE
}

fun main() {
    //性别 MALE
    var person = Person(Gender.MALE)
    person.name = "Love"
    println("打印结果：${person.name}")
    //性别FEMALE
    var person2 = Person(Gender.FEMALE)
    person2.name = "Love"
    println("打印结果：${person2.name}")

}



