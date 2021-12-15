import java.lang.reflect.Method;
import java.util.*;

public class SugarTest {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<Integer, String>();
        map.put(1,"No1");
        map.put(2,"No2");
        System.out.println(map.get(1));
        System.out.println(map.get(2));

        //反射绕过编译器检查
        List<String> stringList = new ArrayList<>();
        stringList.add("erdai");
        stringList.add("666");

        //使用反射增加一个新的元素
        Class<? extends List> aClass = stringList.getClass();
        try {
            Method method = aClass.getMethod("add",Object.class);
            method.invoke(stringList,123);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Iterator iterator = stringList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //情况1：擦除所有类型参数信息，如果类型参数是有界的，则将每个参数替换为其第一个边界；如果类型参数是无界的，则将其替换为 Object
    class Paint {
        void draw() {
            System.out.println("Paint.draw() called");
        }
    }

    //如果不给T设置边界，那么work方法里面的t就调用不到draw方法
    class Painter<T extends Paint> {
        private T t;
        public Painter(T t) {
            this.t = t;
        }
        public void work() {
            t.draw();
        }
    }

    //情况2：（必要时）插入类型转换，以保持类型安全(编译器做了强转的工作)
    public class JavaGenericWipe {
        public static void main(String[] args) {
            List<String> stringList = new ArrayList<>();
            stringList.add("erdai");
            stringList.add("666");

            for (String s: stringList) {
                System.out.println(s);
            }
        }
    }

    //情况3：（必要时）生成桥接方法以在子类中保留多态性(编译器生成桥接方法)
    class Node {
        public Object data;

        public Node(Object data) {
            this.data = data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }

    class MyNode extends Node {
        public MyNode(Integer data) {
            super(data);
        }

        public void setData(Integer data) {
            super.setData(data);
        }
    }


}



