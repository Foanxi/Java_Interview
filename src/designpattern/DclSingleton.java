package designpattern;

/**
 * @author foanxi
 */
public class DclSingleton {
    /**
     * volatile解决共享变量的有序性和可见性问题
     */
    private static volatile DclSingleton instance = null;

    private DclSingleton() {
    }

    private DclSingleton getInstance() {
        if (instance == null) {
            synchronized (DclSingleton.class) {
                /* 第二次判断，原因是如果线程相互竞争的时候
                   如果没有if条件，那么第一个线程创建完成后释放锁的时候
                   第二个线程进来还会再覆盖一次创建一个新的对象
                 */
                if (instance == null) {
                    instance = new DclSingleton();
                }
            }
        }
        return instance;
    }

}