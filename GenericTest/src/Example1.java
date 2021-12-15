import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Example1 {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        /*******************一个会报错的例子********************/
//        List<String> arrayList = new ArrayList<String>();
//        arrayList.add("aaaa");
//        arrayList.add(100);
//
//        for (int i=0;i<arrayList.size();i++){
//            String item = (String) arrayList.get(i);
//            System.out.println("泛型测试: item=" + item);
//        }

        /*******************泛型特性*************************/
        //泛型类型在逻辑上看似是多个不同的类型，实际上都是相同的基本类型
        List<String> stringArrayList = new ArrayList<String>();
        List<Integer> integerArrayList = new ArrayList<Integer>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        if (classIntegerArrayList.equals(classIntegerArrayList)) {
            System.out.println("泛型测试：类型相同");
        }

        /********************泛型的使用***********************/

        /********************泛型类***********************/
        //泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
        //传入的实参类型要与泛型类型参数相同
        Generic<Integer> genericInteger = new Generic<Integer>(123456);
        Generic<String> genericString = new Generic<String>("key_value");
        System.out.println("泛型测试，key is " + genericInteger.getKey());
        System.out.println("泛型测试，key is " + genericString.getKey());

        //定义泛型类不一定要传入泛型类型实参，如果不传入泛型类型实参的话，在泛型类中使用泛型的方法或成员变量定义的类型可以为任何的类型
        Generic generic = new Generic("1111111");
        Generic generic1 = new Generic(4444);
        Generic generic2 = new Generic(55.55);
        Generic generic3 = new Generic(false);
        System.out.println("泛型测试，key is " + generic.getKey());
        System.out.println("泛型测试，key is " + generic1.getKey());
        System.out.println("泛型测试，key is " + generic2.getKey());
        System.out.println("泛型测试，key is " + generic3.getKey());

        /***********************泛型接口*********************/
        //1. 当实现泛型接口的类，未传入泛型实参时：FruitGenerator.java
        //2. 当实现泛型接口的类，传入泛型实参时：ComputerGenerator.java

        /*********************泛型通配符********************/
        Generic<Integer> gInteger = new Generic<Integer>(123);
        Generic<Number> gNumber = new Generic<Number>(456);
        //同一种泛型可以对应多个版本（因为参数类型是不确定的），不同版本的泛型类实例是不兼容的
        Example1 test = new Example1();
        test.showKeyValue(gInteger);

        /********************泛型方法*********************/
//        Object obj = test.genericMethod(Class.forName("java.util.List"));
        //泛型方法与可变参数
        test.printMsg("111",222,"aaaa","2312.4",55.55);
        /**
         * 静态方法与泛型{@link GenericFruit}
         * @see GenericFruit#show(T)
         */

        /*******************泛型上下边界******************/
        //1. 为泛型添加上边界
        Generic<String> generic4 = new Generic<String>("1111");
        Generic<Integer> generic5 = new Generic<Integer>(222);
        Generic<Float> generic6 = new Generic<Float>(2.4f);
        Generic<Double> generic7 = new Generic<Double>(2.56);
//        test.showKeyValue1(generic4);//报错，因为String类并不是Number的子类
        test.showKeyValue1(generic5);
        test.showKeyValue1(generic6);
        test.showKeyValue1(generic7);

        /*********************泛型数组******************/
//        List<String>[] ls = new ArrayList<String>[10];//不能创建一个确切的泛型类型的数组
        List<?>[] ls = new ArrayList<?>[10];//可以使用通配符创建泛型数组，因为对于通配符方式，最后取出数据要做显式的类型转换
    }

    /**
     * 原始方法
     * 同一种泛型可以对应多个版本（因为参数类型是不确定的），不同版本的泛型类实例是不兼容的
     * @param obj
     */
//    public void showKeyValue(Generic<Number> obj) {
//        System.out.println("泛型测试，key value is " + obj.getKey());
//    }
    /**
     * 修改后的方法
     * 1.同一种泛型可以对应多个版本（因为参数类型是不确定的），不同版本的泛型类实例是不兼容的
     * 2.类型通配符一般使用"?"代替具体的类型实参，此处"?"是类似于Number，String等实际类型的类型实参，不是类型形参
     * 3.适用情况：
     *   1）具体类型不确定时
     *   2）不需要使用类型的具体功能，或者只使用Object类中的功能时
     * @param obj
     */
    public void showKeyValue(Generic<?> obj) {
        System.out.println("泛型测试，key value is " + obj.getKey());
    }

    /**
     * 泛型方法的基本介绍
     * 深入一点的介绍：{@link GenericFruit}
     * @param tClass 传入的泛型实参
     * @param <T> 返回值为T类型
     * 说明：
     *    1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     *    2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     *    3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     *    4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     * @return
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public <T> T genericMethod(Class<T> tClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        T instance = tClass.getDeclaredConstructor().newInstance();
        return instance;
    }

    /**
     * 泛型方法和可变参数
     * @param args
     * @param <T>
     */
    public <T> void printMsg(T... args){
        for (T t:args) {
            System.out.println("泛型测试，t is " + t);
        }
    }

    /**
     * 为泛型添加上边界
     * @param obj
     */
    public void showKeyValue1(Generic<? extends Number> obj) {
        System.out.println("泛型测试，key value is " + obj.getKey());
    }
}
