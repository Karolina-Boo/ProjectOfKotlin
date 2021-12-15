/**
 * lazy()接受一个lambda，返回一个lazy<T>实例的函数，返回的实例可作为实现延迟属性的委托：
 *  第一次调用 get() 会执行已传递给 lazy() 的 lambda 表达式并记录结果， 后续调用 get() 只是返回记录的结果
 */
val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}

/**
 * LazyThreadSafetyMode.SYNCHRONIZED：初始化属性时会有双重锁检查，保证该值只在一个线程中计算，并且所有线程会得到相同的值。
 * LazyThreadSafetyMode.PUBLICATION：多个线程会同时执行，初始化属性的函数会被多次调用，但是只有第一个返回的值被当做委托属性的值。
 * LazyThreadSafetyMode.NONE：没有双重锁检查，不应该用在多线程下。
 */
val byInt: Int by lazy(mode = LazyThreadSafetyMode.NONE){
    Int.MAX_VALUE
}

/**
 * lateinit 则用于只能生命周期流程中进行获取或者初始化的变量，比如 Android 的 onCreate()
 */

fun main(args: Array<String>) {
    println(lazyValue)
    println(lazyValue)
}