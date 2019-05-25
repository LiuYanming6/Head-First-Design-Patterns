package headfirst.designpatterns.singleton.threadsafe;

import java.io.ObjectStreamException;
import java.io.Serializable;

/*
lazy load, 同步操作降低效率

这里实现序列化只是为了测试 序列化和反序列话可以访问私有构造函数而破坏单例.
 */
public class Singleton implements Serializable{
    private static Singleton uniqueInstance;

    // other useful instance variables here

    private Singleton() {
        //反射问题解决: 只能抛出异常,禁止创建实例
        if (uniqueInstance != null) {
            throw new RuntimeException("禁止使用构造函数, 请使用getInstance()");
        }
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

    //序列化问题解决: 反序列话会自动调用这个方法
    private Object readResolve() throws ObjectStreamException{
        return uniqueInstance;
    }
}

