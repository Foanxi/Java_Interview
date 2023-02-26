package designpattern;


/**
 * @author foanxi
 */
public class Singleton2 {
    private static Singleton2 instance = null;

    /**
     * 必须使用synchronized保证同步，否则可能会导致多线程并发使用getInstance的时候得到多个实例
     */
    public static synchronized Singleton2 getInstance(){
        if (instance==null){
            instance = new Singleton2();
        }
        return instance;
    }
}
