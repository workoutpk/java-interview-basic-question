package dsa.vector;

import java.util.Vector;

public class VectorExample1 {
    public static void main(String[] args) {

        Vector<String> vec = new Vector<>();  // Create empty Vector
        vec.add("First");                    // Add element
        vec.add("Second");                   // Add another element
        String element = vec.get(0);         // Get first element

        System.out.println("vector element at 0 index is  :::  " + element);
    }
}
