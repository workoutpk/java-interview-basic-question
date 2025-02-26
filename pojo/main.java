package pojo;

public class main {
    public static void main(String[] args) {
//        Animal animal =  new Dog();
        Dog dog1 = new Dog();
//        animal.sound();
//        dog1.sound();

        System.out.println("Dog1 - Name: " + dog1.getName() + ", Breed: " + dog1.getBreed());


        System.out.println();

        Dog dog2 = new Dog("Buddy", "Golden Retriever");
        System.out.println("Dog2 - Name: " + dog2.getName() + ", Breed: " + dog2.getBreed());
    }
}
