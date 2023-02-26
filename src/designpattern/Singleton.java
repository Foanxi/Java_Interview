package designpattern;

import sun.misc.Unsafe;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author foanxi
 */
public class Singleton implements Serializable {
    /**
     * 定义一个private的空参构造方法，限制了除了本类以外的其他所有类都无法创建该类的实例
     */
    private Singleton() {
        if (INSTANCE != null) {
            throw new RuntimeException();
        }
    }

    /**
     * 创建一个实例
     */
    private static final Singleton INSTANCE = new Singleton();

    public static Singleton getInstance() {
        return INSTANCE;
    }

    private static void reflection(Class<?> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 获取到相应类的无参构造方法
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        // 将其中的private方法改变为允许外部调用
        constructor.setAccessible(true);
        //使用构造器直接创造新的实例，破坏了单例
        constructor.newInstance();
    }

    /**
     * 首先使用输出流将对象输出保存
     * 然后使用输入流读取并序列化为一个新的对象
     * 从而实现破坏单例
     * @param instance 需要破坏的单例
     * @throws IOException IO异常
     */
    private static void serializable(Object instance) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(instance);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
    }

    public Object readResolve(){
        return INSTANCE;
    }

    private static void unsafe(Class<?> clazz) throws InstantiationException {
        Object o = Unsafe.getUnsafe().allocateInstance(clazz);
    }
}
