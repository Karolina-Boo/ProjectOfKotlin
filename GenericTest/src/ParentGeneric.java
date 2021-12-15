import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ParentGeneric<T> {

}

class SubClass extends ParentGeneric<String> {

}

class SubClass2<T> extends ParentGeneric<T> {

}

class GenericGet {

    //获取实际的泛型类型
    public static <T> Type findGenericType(Class<T> cls) {
        //获取当前带有泛型的父类
        Type genType = cls.getGenericSuperclass();
        Type finalNeedType = null;
        //如果当前genType是参数化类型则进入条件体
        if (genType instanceof ParameterizedType) {
            //获取参数类型<>里面的那些值，例如Map<K,V>那么就得到[K,V]的一个数组
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
            //将第一个泛型类型赋值给finalNeedType
            finalNeedType = params[0];
        }
        return finalNeedType;
    }

    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        SubClass2<Integer> subClass2 = new SubClass2<Integer>();
        //打印subClass获取的泛型
        System.out.println("subClass: " + findGenericType(subClass.getClass()));
        //打印subClass2获取的泛型
        System.out.println("subClass: " + findGenericType(subClass2.getClass()));

        //打印父类
        System.out.println(subClass.getClass().getGenericSuperclass());
        System.out.println(subClass2.getClass().getGenericSuperclass());

        ParentGeneric<String> parentGeneric1 = new ParentGeneric<String>();
        //匿名内部类，是一个子类，它继承了泛型父类，然后给这个泛型一个实际的类型
        ParentGeneric<String> parentGeneric2 = new ParentGeneric<String>(){};

        //打印parentGeneric1获取的泛型
        System.out.println("parentGeneric1: " + findGenericType(parentGeneric1.getClass()));
        //打印parentGeneric2获取的泛型
        System.out.println("parentGeneric2: " + findGenericType(parentGeneric2.getClass()));

        //打印父类
        System.out.println(parentGeneric1.getClass().getGenericSuperclass());
        System.out.println(parentGeneric2.getClass().getGenericSuperclass());
    }
}