public class ConstTestJ {
    //java中，没有用const修饰的，需要通过getter方法来获取属性信息，而用了const修饰的属性，可以直接通过类引用
    public static void main(String[] args) {

        System.out.println(ConstTestKt.constVariable);
        System.out.println(ConstTestKt.getNonConstVariable());

        System.out.println(obj.constVariableObj);
        System.out.println(obj.INSTANCE.getNonConstVariableObj());

        System.out.println(ConstTest.constVariableCompanion);
        System.out.println(ConstTest.Companion.getNonConstVariableCompanion());
    }
}
