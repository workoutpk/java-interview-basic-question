package self.test;

public class Child extends Parent{
    void msg() throws ArithmeticException{
        System.out.println("Child message ");
    }

    public static void main(String[] args) {
        Parent parent =  new Child();
        Child child =  new Child();
        try {
            parent.msg();
            child.msg();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
