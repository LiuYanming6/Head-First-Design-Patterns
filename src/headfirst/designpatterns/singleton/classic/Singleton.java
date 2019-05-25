package headfirst.designpatterns.singleton.classic;

/* NOTE: This is not thread safe!
 懒汉式, 延时创建
 不要用这个方式
 */
public class Singleton {
    private static Singleton uniqueInstance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            // 两个线程可能同事跑到这里, 所以线程不安全
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    // other useful methods here
    public String getDescription() {
        return "I'm a classic Singleton!";
    }
}
