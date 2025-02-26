package designpattern.singleton;

public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();
    EagerSingleton(){

    }
    public static  EagerSingleton getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        EagerSingleton eagerSingleton1 =  getInstance();
        EagerSingleton eagerSingleton2 =  getInstance();
        System.out.println(eagerSingleton1.hashCode());
        System.out.println(eagerSingleton2.hashCode());
    }
}
