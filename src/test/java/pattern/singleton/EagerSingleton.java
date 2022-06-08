package pattern.singleton;

/**
 * 单例模式
 * 该类最多只能有一个实例
 * 饿汉式
 * 并发安全
 */

public class EagerSingleton {
    private static EagerSingleton singleton = new EagerSingleton();

    private EagerSingleton() {

    }

    public static EagerSingleton getSingleton() {
        return singleton;
    }

    public static void main(String[] args) {
        final EagerSingleton singleton = EagerSingleton.getSingleton();
        final EagerSingleton singleton2 = EagerSingleton.getSingleton();
        System.out.println(singleton == singleton2);
    }
}
