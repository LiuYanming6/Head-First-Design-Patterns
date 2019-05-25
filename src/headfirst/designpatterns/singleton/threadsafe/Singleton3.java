package headfirst.designpatterns.singleton.threadsafe;

/**
 * @Author: 刘艳明
 * @Date: 19-5-25 下午5:30
 */ /*
实现简单
枚举本身就是单例模式,由JVM从根本上提供保障,避免通过反射和反序列化的漏洞
无延时加载
 */
public enum Singleton3{
    INSTANCE;

    public String getDescription() {
        return "I'm a enum Singleton!";
    }
}
