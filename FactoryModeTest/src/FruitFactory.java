/**
 *  简单工厂设计模式
 *  具体工厂：水果工厂
 */
public class FruitFactory {
    public Fruit createFruit(String type) {
        if (type.equals("apple")) { //生产苹果
            return new Apple();
        } else if (type.equals("pear")) { //生产梨
            return new Pear();
        }
        return null;
    }
}
