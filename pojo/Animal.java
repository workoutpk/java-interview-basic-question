package pojo;

public class Animal {
    private String name;
    public Animal() {
        this.name = "Unknown";
        System.out.println("Animal constructor called");
    }

    public Animal(String name) {
        this.name = name;
        System.out.println("Animal constructor with name parameter called");
    }
    public String getName() {
        return name;
    }

    void sound() {
        System.out.println("Generic Sound");
    }
}

class Dog extends Animal {
    private String breed;

    public Dog() {
        super(); // Calls the no-arg constructor of Animal
        this.breed = "Unknown";
        System.out.println("Dog constructor called");
    }

    public Dog(String name, String breed) {
        super(name); // Calls the parameterized constructor of Animal
        this.breed = breed;
        System.out.println("Dog constructor with name and breed parameters called");
    }

    public String getBreed() {
        return breed;
    }
    void sound() {
        System.out.println("Bark");
    }
}

