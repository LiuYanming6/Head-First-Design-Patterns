package headfirst.designpatterns.singleton.threadsafe;

/**
 * @Author: 刘艳明
 * @Date: 19-5-25 下午5:30
 */ /*
在一些开源框架中看到这种方式, 本书没有结束

懒加载, 高效, 线程安全

外部类灭有static属性,则不会立即加载对象.
只用调用 get, 才会加载静态内部类
 */
public class Singleton2 {
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
