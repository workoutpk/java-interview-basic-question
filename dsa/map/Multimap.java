package dsa.map;

import java.util.*;

public class Multimap<K, V> {
    private Map<K, Collection<V>> map = new HashMap<>();

    // Adds a key-value pair to the multimap
    public void put(K key, V value) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }

    // Adds multiple values for a key
    public void putAll(K key, Collection<V> values) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).addAll(values);
    }

    // Gets all values for a key
    public Collection<V> get(K key) {
        return map.getOrDefault(key, Collections.emptyList());
    }

    // Removes a key-value pair
    public boolean remove(K key, V value) {
        Collection<V> values = map.get(key);
        if (values != null) {
            boolean removed = values.remove(value);
            if (values.isEmpty()) {
                map.remove(key);
            }
            return removed;
        }
        return false;
    }

    // Removes all values for a key
    public Collection<V> removeAll(K key) {
        return map.remove(key);
    }

    // Checks if the multimap contains a key
    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    // Checks if the multimap contains a value
    public boolean containsValue(V value) {
        return map.values().stream()
                .anyMatch(collection -> collection.contains(value));
    }

    // Gets all entries
    public Set<Map.Entry<K, Collection<V>>> entries() {
        return map.entrySet();
    }

    // Gets all keys
    public Set<K> keySet() {
        return map.keySet();
    }

    // Gets all values
    public Collection<V> values() {
        List<V> values = new ArrayList<>();
        map.values().forEach(values::addAll);
        return values;
    }

    // Clears the multimap
    public void clear() {
        map.clear();
    }

    // Gets the size of the multimap
    public int size() {
        return map.values().stream()
                .mapToInt(Collection::size)
                .sum();
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
