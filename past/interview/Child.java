package past.interview;

public class Child extends Parent {
    void msg() {
        System.out.println("Child method ");
    }

    @Override
    void showNew() {
        super.showNew(); // Calls the parent class's show() method
        System.out.println("Child's show()");
    }

    public static void main(String[] args) {
        Parent p = new Child();
        Parent c = new Parent();
        Child ch = new Child();

        System.out.println("Child override new instance ::: ");
        Child child = new Child();
        child.showNew();

        try {
            p.msg();
            c.msg();
            ch.msg();
        } catch (Exception e) {
            System.out.println("Error is  ::: " + e);
        }
    }


}
