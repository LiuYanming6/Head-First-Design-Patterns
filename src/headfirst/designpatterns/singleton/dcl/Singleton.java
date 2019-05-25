package headfirst.designpatterns.singleton.dcl;

/*
 Danger!  This implementation of Singleton not
 guaranteed to work prior to Java 5

 double check lock
 双重检测锁, 线程安全, lazy load
 很少用
*/

public class Singleton {
    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        /*
        同步放到了 if 内部,只有第一次才同步,提高了每次获取的效率
         */
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
