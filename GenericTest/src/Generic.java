import java.awt.*;
import java.security.Key;

/**
 * 泛型类
 * T可以写为任意形式，但在实例化泛型类时，必须指定T的具体类型
 */
public class Generic<T> {
    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }
}
