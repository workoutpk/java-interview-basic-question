Here is a list of all commonly used methods in the **Java `HashMap`** class, along with their return types and descriptions:

---

### **Constructors**
1. `HashMap()`
    - **Description**: Creates an empty `HashMap`.
    - **Return Type**: None (constructor).

2. `HashMap(int initialCapacity)`
    - **Description**: Creates a `HashMap` with the specified initial capacity.
    - **Return Type**: None (constructor).

3. `HashMap(int initialCapacity, float loadFactor)`
    - **Description**: Creates a `HashMap` with the specified initial capacity and load factor.
    - **Return Type**: None (constructor).

4. `HashMap(Map<? extends K, ? extends V> m)`
    - **Description**: Creates a `HashMap` with the same mappings as the specified map.
    - **Return Type**: None (constructor).

---

### **HashMap Methods**

| **Method**                                       | **Return Type**                | **Description**                                                                 |
|--------------------------------------------------|---------------------------------|---------------------------------------------------------------------------------|
| `void clear()`                                   | `void`                         | Removes all the mappings from this map.                                        |
| `Object clone()`                                 | `Object`                       | Returns a shallow copy of this `HashMap`.                                      |
| `boolean containsKey(Object key)`               | `boolean`                      | Returns `true` if this map contains a mapping for the specified key.           |
| `boolean containsValue(Object value)`           | `boolean`                      | Returns `true` if this map maps one or more keys to the specified value.       |
| `Set<Map.Entry<K, V>> entrySet()`               | `Set<Map.Entry<K, V>>`         | Returns a `Set` view of the mappings contained in this map.                    |
| `boolean equals(Object o)`                      | `boolean`                      | Compares the specified object with this map for equality.                      |
| `V get(Object key)`                             | `V`                            | Returns the value to which the specified key is mapped, or `null` if no mapping.|
| `int hashCode()`                                | `int`                          | Returns the hash code value for this map.                                      |
| `boolean isEmpty()`                             | `boolean`                      | Returns `true` if this map contains no key-value mappings.                     |
| `Set<K> keySet()`                               | `Set<K>`                       | Returns a `Set` view of the keys contained in this map.                        |
| `V put(K key, V value)`                         | `V`                            | Associates the specified value with the specified key in this map.             |
| `void putAll(Map<? extends K, ? extends V> m)`  | `void`                         | Copies all of the mappings from the specified map to this map.                 |
| `V putIfAbsent(K key, V value)`                 | `V`                            | Associates the value with the key if it is not already associated.             |
| `V remove(Object key)`                          | `V`                            | Removes the mapping for the specified key if present.                          |
| `boolean remove(Object key, Object value)`      | `boolean`                      | Removes the entry for the specified key only if it is currently mapped to the specified value. |
| `int size()`                                    | `int`                          | Returns the number of key-value mappings in this map.                          |
| `Collection<V> values()`                        | `Collection<V>`                | Returns a `Collection` view of the values contained in this map.               |
| `V replace(K key, V value)`                     | `V`                            | Replaces the entry for the specified key only if it is currently mapped.       |
| `boolean replace(K key, V oldValue, V newValue)`| `boolean`                      | Replaces the entry for the specified key only if currently mapped to a value.  |
| `V getOrDefault(Object key, V defaultValue)`    | `V`                            | Returns the value for the key or the default value if no mapping exists.       |
| `void forEach(BiConsumer<? super K, ? super V> action)`| `void`                    | Performs the given action for each entry in this map.                          |
| `V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)`| `V` | Computes a new value for the key and updates the map.                          |
| `V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)`| `V`| Computes a value if the key is not already associated with one.               |
| `V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)`| `V` | Computes a new value for an existing key only if it is present.               |
| `V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)`| `V` | Merges a value with the existing value for a key.                             |

---

### **Additional Notes**
- Replace `K` and `V` with the actual key and value types when implementing a `HashMap`.
- Use **`compute*`** methods for on-the-fly updates or conditional additions.
- The **`forEach`**, **`compute*`**, and **`merge`** methods were introduced in Java 8 for functional-style programming.

Let me know if you'd like examples for specific methods!