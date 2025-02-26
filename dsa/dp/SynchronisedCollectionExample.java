package dsa.dp;

import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class SynchronisedCollectionExample {
    public static void main(String[] args) {
        List<String> syncList = Collections.synchronizedList(new ArrayList<>());
        List synchronizedList = Collections.synchronizedList(new ArrayList<>());
        Set synchronizedSet = Collections.synchronizedSet(new HashSet<>());
        Map synchronizedMap = Collections.synchronizedMap(new HashMap<>());
        Map synCocurrentMap = Collections.synchronizedMap(new ConcurrentHashMap<>());
        // Adding elements
        syncList.add("Element1");
        syncList.add("Element2");

        // Synchronized access
        synchronized(syncList) {
            for (String item : syncList) {
                System.out.println(item);
            }
        }
    }
}
