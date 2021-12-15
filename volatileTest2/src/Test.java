/**
 * 使用volatile，保证inc可见性，不保证原子性，导致输出结果小于10000
 * volatile在一定程度上保证有序性
 * “观察加入volatile关键字和没有加入volatile关键字时所生成的汇编代码发现，加入volatile关键字时，会多出一个lock前缀指令”
 *
 * 　　lock前缀指令实际上相当于一个内存屏障（也成内存栅栏），内存屏障会提供3个功能：
 *
 * 　　1）它确保指令重排序时不会把其后面的指令排到内存屏障之前的位置，也不会把前面的指令排到内存屏障的后面；即在执行到内存屏障这句指令时，在它前面的操作已经全部完成；
 *
 * 　　2）它会强制将对缓存的修改操作立即写入主存；
 *
 * 　　3）如果是写操作，它会导致其他CPU中对应的缓存行无效。
 * 使用volatile的条件：
 * 　1）对变量的写操作不依赖于当前值
 *
 * 　2）该变量没有包含在具有其他变量的不变式中
 */
public class Test {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final Test test = new Test();
        for (int i=0;i<10;i++) {
            new Thread() {
                public void run() {
                    for (int j=0;j<1000;j++)
                        test.increase();
                }
            }.start();
        }

        while (Thread.activeCount() > 1)
            Thread.yield();
        System.out.println(test.inc);
    }
}


///**
// * 使用synchronized，保证inc可见性和原子性，输出结果等于10000
// */
//public class Test {
//    public int inc = 0;
//
//    public synchronized void increase() {
//        inc++;
//    }
//
//    public static void main(String[] args) {
//        final Test test = new Test();
//        for (int i=0;i<10;i++) {
//            new Thread() {
//                public void run() {
//                    for (int j=0;j<1000;j++)
//                        test.increase();
//                }
//            }.start();
//        }
//
//        while (Thread.activeCount() > 1)
//            Thread.yield();
//        System.out.println(test.inc);
//    }
//}

//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Lock，保证inc可见性和原子性，输出结果等于10000
 */
//public class Test {
//    public int inc = 0;
//    Lock lock = new ReentrantLock();
//
//    public void increase() {
//        lock.lock();
//        try {
//            inc++;
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public static void main(String[] args) {
//        final Test test = new Test();
//        for (int i=0;i<10;i++) {
//            new Thread() {
//                public void run() {
//                    for (int j=0;j<1000;j++)
//                        test.increase();
//                }
//            }.start();
//        }
//
//        while (Thread.activeCount() > 1)
//            Thread.yield();
//        System.out.println(test.inc);
//    }
//}

/**
 * 使用AtomicInteger，保证inc可见性和原子性，输出结果等于10000
 * atomic利用CAS实现原子性操作，CAS利用处理器提供的CMPXCHG指令实现
 */
//public class Test {
//    public AtomicInteger inc = new AtomicInteger();
//
//    public void increase() {
//        inc.getAndIncrement();
//    }
//
//    public static void main(String[] args) {
//        final Test test = new Test();
//        for (int i=0;i<10;i++) {
//            new Thread() {
//                public void run() {
//                    for (int j=0;j<1000;j++)
//                        test.increase();
//                }
//            }.start();
//        }
//
//        while (Thread.activeCount() > 1)
//            Thread.yield();
//        System.out.println(test.inc);
//    }
//}