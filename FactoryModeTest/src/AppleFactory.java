/**
 * 苹果工厂
 */
public class AppleFactory implements FruitFactoryInterface {
    @Override
    public Fruit createFruit() {
        return new Apple();
    }
}
