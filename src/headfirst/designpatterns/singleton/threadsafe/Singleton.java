package headfirst.designpatterns.singleton.threadsafe;

/*
lazy load, 同步操作降低效率
 */
public class Singleton {
    private static Singleton uniqueInstance;

    // other useful instance variables here

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    // other useful methods here
    public String getDescription() {
        return "I'm a thread safe Singleton!";
    }
}

/*
在一些开源框架中看到这种方式, 本书没有结束

懒加载, 高效, 线程安全

外部类灭有static属性,则不会立即加载对象.
只用调用 get, 才会加载静态内部类
 */
class Singleton2 {
    private static class SingletonClassInstance{
        private static final Singleton2 uniqueInstance = new Singleton2();
    }

    // other useful instance variables here

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return SingletonClassInstance.uniqueInstance;
    }

    // other useful methods here
    public String getDescription() {
        return "I'm a thread safe and lazy load Singleton!";
    }
}

/*
实现简单
枚举本身就是单例模式,由JVM从根本上提供保障,避免通过反射和反序列化的漏洞
无延时加载
 */
enum Singleton3{
    INSTANCE;

    public String getDescription() {
        return "I'm a enum Singleton!";
    }
}
