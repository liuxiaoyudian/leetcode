package 设计模式;

public class Singleton {

    // 饿汉模式
//    private static Singleton instance = new Singleton();
//
//    private Singleton() {}
//
//    public static Singleton getInstance() {
//        return instance;
//    }

    // 懒汉模式
//    private static Singleton instance = null;
//
//    private Singleton() {}
//
////    public synchronized static Singleton getInstance() {
//    public static Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }

    // 双重锁懒汉 (DLC)
    private volatile static Singleton instance = null;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // 静态内部类
//    private Singleton() {}
//
//    private static class SingletonHolder {
//        private static Singleton instance = new Singleton();
//    }
//
//    public static Singleton getInstance() {
//        return SingletonHolder.instance;
//    }


}


// 枚举
//public enum Singleton {
//    instance;
//}