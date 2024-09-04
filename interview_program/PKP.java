package interview_program;

public class PKP {
        public static void main(String[] args) {

                // method
                Child obj = new Child();

                // Printing the reference of child type
                System.out.println("Reference of Child Type :"
                        + obj.value);

                // Note that doing "Parent par = new Child()"
                // would produce same result
                Parent par = obj;

                // Par holding obj will access the value
                // variable of parent class

                // Printing the reference of parent type
                System.out.println("Reference of Parent Type : "
                        + par.value);
        }
}
