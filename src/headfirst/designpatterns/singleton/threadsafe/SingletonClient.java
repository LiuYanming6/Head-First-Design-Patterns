package headfirst.designpatterns.singleton.threadsafe;

public class SingletonClient {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.getDescription());

        Singleton2 singleton2 = Singleton2.getInstance();
        System.out.println(singleton2.getDescription());

        Singleton3 e1 = Singleton3.INSTANCE;
        Singleton3 e2 = Singleton3.INSTANCE;
        System.out.println(e2.getDescription());
        System.out.println(e1 == e2);
    }
}
