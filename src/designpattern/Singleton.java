package designpattern;

/**
 * @author foanxi
 */
public class Singleton {
    /**
    定义一个private的空参构造方法，限制了除了本类以外的其他所有类都无法创建该类的实例
     */
    private Singleton(){}
    /**
     * 创建一个实例
     */
    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}
