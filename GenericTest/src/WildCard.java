import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WildCard {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<Integer>();
        List<Number> numberList = new ArrayList<Number>();
        List<Object> objectList = new ArrayList<Object>();
        List<String> stringList = new ArrayList<String>();
        integerList.add(666);
        numberList.add(123);
        stringList.add("erdai");

        getNumberData(integerList);
        getNumberData(numberList);

        setNumberData(numberList);
        setNumberData(objectList);

        getData(stringList);
        getData(numberList);
        getData(integerList);

    }

    //使用上边界通配符的变量只读，不可以写，可以添加null,但是没意义
    public static void getNumberData(List<? extends Number> data) {
//        data.add(0);//编译错误
        System.out.println("Number data: " + data.get(0));
    }

    //使用下边界接口或者其父接口，使用下边界通配符的变量只写，不建议读
    public static void setNumberData(List<? super Number> data) {
        Number number = Integer.valueOf(666);
        data.add(number);
    }

    //无边界通配符的语法结构：<?>，实际上它等价于 <? extends Object>，也就是说它的上边界是 Object 或其子类，
    // 因此使用无界通配符的变量同样只读，不能写，可以添加 null ，但是没意义
    public static void getData(List<?> data) {
        System.out.println("data: " + data.get(0));
    }
}

