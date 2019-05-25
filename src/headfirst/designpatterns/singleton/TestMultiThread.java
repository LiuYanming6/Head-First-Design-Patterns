package headfirst.designpatterns.singleton;

import headfirst.designpatterns.singleton.threadsafe.Singleton3;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 * @Author: 刘艳明
 * @Date: 19-5-25 下午5:03
 *
 * 测试单例模式的创建性能
 *
 * 锁开销还是挺大的
 */
public class TestMultiThread {
    public static void main(String[] args) throws InterruptedException {
        int iThread = 10;

        long start = System.currentTimeMillis();

        CountDownLatch countDownLatch = new CountDownLatch(iThread);
        IntStream.range(0, iThread).forEach(i -> {
            new Thread(() -> {
                IntStream.range(0, 1000000).forEach(j -> {
//                            headfirst.designpatterns.singleton.stat.Singleton.getInstance();       // 75 左右, 饿汉式,无锁
                            headfirst.designpatterns.singleton.threadsafe.Singleton.getInstance(); // 220左右  lazy load, 同步
//                            headfirst.designpatterns.singleton.threadsafe.Singleton2.getInstance();  // 75 左右, 饿汉式,无锁, lazy load(静态内部类实现)
//                            Singleton3 tmp = Singleton3.INSTANCE;  // 75 枚举
                        }
                );

                countDownLatch.countDown();
            }).start();

        });

        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start));
    }
}
