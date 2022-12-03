package designpattern;


public class Singleton2 {
    private static Singleton2 instance = null;

    /**
     * 必须使用synchronized保证同步，否则
     * @return
     */
    public static synchronized Singleton2 getInstance(){
        if (instance==null){
            instance = new Singleton2();
        }
        return instance;
    }
}
