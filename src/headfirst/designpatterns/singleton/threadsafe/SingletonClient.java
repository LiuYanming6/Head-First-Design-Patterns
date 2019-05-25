package headfirst.designpatterns.singleton.threadsafe;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SingletonClient {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        System.out.println(s1.getDescription());

        /*
        通过反射和序列化可以访问私有构造器,破坏单例
        一般写项目不会这样用, 但是写框架时, 要注意在私有构造函数中抛异常
         */
        Singleton s2 = null;
        try {
//            Class<Singleton> Clazz = (Class<Singleton>) Class.forName("headfirst.designpatterns.singleton.threadsafe.Singleton");
//            Constructor<Singleton> constructor = Clazz.getDeclaredConstructor();
//            constructor.setAccessible(true);    //可以访问私有方法
//            s2 = constructor.newInstance();
//            System.out.println(s1 == s2);

            //序列化和反序列化
            String objectFile = "/tmp/a.txt";
            Files.delete(Paths.get(objectFile));
            FileOutputStream fos = new FileOutputStream(objectFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s1);
            oos.close();fos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objectFile));
            Singleton s3 = (Singleton)ois.readObject();
            System.out.println(s1 == s3);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            //IllegalAccessException
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Singleton2 singleton2 = Singleton2.getInstance();
        System.out.println(singleton2.getDescription());

        Singleton3 e1 = Singleton3.INSTANCE;
        Singleton3 e2 = Singleton3.INSTANCE;
        System.out.println(e2.getDescription());
        System.out.println(e1 == e2);
    }
}
