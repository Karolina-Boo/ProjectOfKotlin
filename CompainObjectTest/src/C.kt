class C {
    //私有函数，所以其返回类型是匿名对象类型
    private fun foo() = object {
        val x: String = "x"
    }

    //公有函数，所以其返回类型是Any
    fun publicFoo() = object {
        val x: String = "x"
    }

    fun bar() {
        val x1 = foo().x
//        val x2 = publicFoo().x //未能解析的引用“x”
    }
}