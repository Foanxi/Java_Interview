package designpattern;

/**
 * @author foanxi
 */
public enum EnumSingleton {
    // 实例对象
    INSTANCE;

    EnumSingleton(){

    }

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
