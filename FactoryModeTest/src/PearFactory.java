/**
 * 梨工厂
 */
public class PearFactory implements FruitFactoryInterface{
    @Override
    public Fruit createFruit() {
        return new Pear();
    }
}
