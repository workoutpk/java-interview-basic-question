package past.interview;

import java.util.HashMap;

class MyHashSet<T> {
    // Internal HashMap to store elements
    private final HashMap<T, Object> map;

    // A dummy value to represent the value for all keys in the HashMap
    private static final Object PRESENT = new Object();

    // Constructor
    public MyHashSet() {
        this.map = new HashMap<>();
    }

    // Add an element to the HashSet
    public boolean add(T element) {
        return map.put(element, PRESENT) == null; // Returns true if the element is added
    }

    // Remove an element from the HashSet
    public boolean remove(T element) {
        return map.remove(element) != null; // Returns true if the element was removed
    }

    // Check if an element exists in the HashSet
    public boolean contains(T element) {
        return map.containsKey(element);
    }

    // Get the size of the HashSet
    public int size() {
        return map.size();
    }

    // Clear all elements from the HashSet
    public void clear() {
        map.clear();
    }

    // Print all elements in the HashSet
    @Override
    public String toString() {
        return map.keySet().toString(); // Print only the keys, which are the elements of the HashSet
    }
}



