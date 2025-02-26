package past.interview;

public class HashSetInternalWorking {
    private static final Object PRESENT = new Object();
    public static void main(String[] args) {
        MyHashSet<String> myHashSet = new MyHashSet<>();

        // Add elements
        myHashSet.add("Apple");
        myHashSet.add("Banana");
        myHashSet.add("Cherry");

        System.out.println("HashSet after adding elements: " + myHashSet);

        // Add a duplicate element
        System.out.println("Adding duplicate 'Apple': " + myHashSet.add("Apple"));

        // Check if an element exists
        System.out.println("Contains 'Banana': " + myHashSet.contains("Banana"));

        // Remove an element
        System.out.println("Removing 'Banana': " + myHashSet.remove("Banana"));

        // Check size
        System.out.println("Size of HashSet: " + myHashSet.size());

        // Clear all elements
        myHashSet.clear();
        System.out.println("HashSet after clearing: " + myHashSet);

        System.out.println("PRESENT ::: "+ PRESENT);
    }
}
