/**
 * SAM(Single Abstract Method) 单一抽象方法
 */
public class SAMTest {
    public static void main(String[] args) {
        //引入Lambda之前，调用Sam类型的接口
        buyBike(new IBuy() {
            @Override
            public void onBuy(double money) {
                System.out.println("buyBike:" + money);
            }
        });
        buyCar(new IBuy() {
            @Override
            public void onBuy(double money) {
                System.out.println("buyCar:" + money);
            }
        });
        //使用Lambda简化对SamType的调用——SAM转换
        buyBike(money -> System.out.println("buyBike:" + money));
        buyCar(money -> System.out.println("buyCar:" + money));
    }

    //不同函数对同一个接口的抽象函数，可以传入不一样的值，进行不一样的操作
    public static void buyBike(IBuy buy) {
        buy.onBuy(500.00);
    }
    public static void buyCar(IBuy buy) {
        buy.onBuy(50000.00);
    }

}
