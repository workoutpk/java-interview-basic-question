package designpattern.singleton;

public class LazySingleton {
    private static volatile LazySingleton instance = null;

    LazySingleton(){
    }

    public static LazySingleton getInstance(){
        synchronized (LazySingleton.class){
            if (instance == null){
                instance = new LazySingleton();
            }
        }
        return instance;
    }
    public static void main(String[] args) {
        LazySingleton obj1 = getInstance();
        LazySingleton obj2 = getInstance();
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());
    }
}
