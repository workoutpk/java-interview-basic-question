package designpattern.singleton;

public class SingletonDesignPatternWithDCL {
    // Step 1: private static variable of INSTANCE variable
    private static volatile SingletonDesignPatternWithDCL INSTANCE;

    // Step 2: private constructor
    private SingletonDesignPatternWithDCL() {

    }

    // Step 3: Provide public static getInstance() method
    // returning INSTANCE after checking
    public static SingletonDesignPatternWithDCL getInstance() {

        // double-checking lock
        if (null == INSTANCE) {

            // synchronized block
            synchronized (SingletonDesignPatternWithDCL.class) {
                if (null == INSTANCE) {
                    INSTANCE = new SingletonDesignPatternWithDCL();
                }
            }
        }
        return INSTANCE;
    }
}
