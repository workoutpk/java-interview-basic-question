package past.interview;

public class Bar extends Foo{
    public Bar() {
        System.out.println("Bar");

    }

    @Override
    public void B() {
        super.B();
        System.out.println("Bar -- Bar");
    }

    public static void main(String[] args) {
        Bar b1= new Bar();
        b1.B();
    }
}
