public class Main {
    public static void main(String[] args) {
        /*************************** 简单工厂设计模式 ********************************
         * 局限性：每当想吃一种新水鬼，就要修改工厂类，违反“开闭原则”
         * 适用场景：产品对象较少，产品固定
         ****************************************************************************/
        FruitFactory mFruitFactory = new FruitFactory();
        Apple apple = (Apple) mFruitFactory.createFruit("apple"); //获得苹果
        Pear pear = (Pear) mFruitFactory.createFruit("pear"); //获得梨
        System.out.println("简单工厂：获得" + apple.whatIm());
        System.out.println("简单工厂：获得" + pear.whatIm());

        /*************************** 工厂方法设计模式 ********************************
         * 局限性：解耦，不违反开闭原则，但每当想吃一种新水鬼，就要新建一个新的工厂类
         * 适用场景：产品对象较少，产品固定
         ****************************************************************************/
        AppleFactory appleFactory = new AppleFactory();
        PearFactory pearFactory = new PearFactory();
        Apple apple1 = (Apple) appleFactory.createFruit(); //获得苹果
        Pear pear1 = (Pear) pearFactory.createFruit(); //获得梨
        System.out.println("工厂方法：获得" + apple1.whatIm());
        System.out.println("工厂方法：获得" + pear1.whatIm());

        /*************************** 抽象工厂设计模式 ********************************
         * 可以解决一系列产品生产需求
         * 适用场景：大批量，多系列的产品
         ****************************************************************************/
        XiaoMiFactory xiaoMiFactory = new XiaoMiFactory();
        HongMiFactory hongMiFactory = new HongMiFactory();
        System.out.println("抽象工厂：小米手机");
        xiaoMiFactory.getCpu().run();
        xiaoMiFactory.getScreen().size();
        System.out.println("抽象工厂：红米手机");
        hongMiFactory.getCpu().run();
        hongMiFactory.getScreen().size();
    }
}
