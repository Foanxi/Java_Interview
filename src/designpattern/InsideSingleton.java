package designpattern;

/**
 * @author foanxi
 */
public class InsideSingleton {

    private static class Holder {
        // 只有在初始化Holder静态类的时候，才会一并加载静态变量Instance完成初始化
        static InsideSingleton INSTANCE = new InsideSingleton();
    }

    public static InsideSingleton getInstance() {
        // 只有在调用getInstance方法的时候才会初始化Holder静态类
        return Holder.INSTANCE;
    }
}