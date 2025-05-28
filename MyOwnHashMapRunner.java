package acn;


import java.util.*;

/*
----Basic Structure of a Custom HashMap----
We’ll simulate the internal structure of Java’s HashMap. The core idea is:
* Use an array of buckets
* Each index (bucket) in the internal array holds a linked list of entries. When a collision happens, new entries are added to the start of the list.
* Each Entry<K, V> holds:
    1. the key
    2. the value
    3. a pointer to the next node


****Concept Explanation****
Buckets	    -    Array of fixed size to distribute entries based on hash
Chaining	-    If two keys hash to same index, link them via a linked list (the latest item gets added at the beginning of the Linked List .
Static Entry-	 To prevent each entry from holding reference to outer MyHashMap class
Generics	-    Use <K, V> to allow the map to work with any key/value type
Hashing     -    Key’s hashCode() determines the bucket index
Equals      -	 Check Needed to detect key duplicates and update rather than insert again

 */

class MyOwnHashMap<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 16;
    private LinkedList<Entry<K, V>>[] buckets;

    public MyOwnHashMap() {
        buckets = new LinkedList[SIZE];
    }

    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    public void put(K key, V value) {

        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        buckets[index].add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        if (bucket != null) {
            for (Entry<K, V> entry : bucket) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        if (bucket != null) {
            bucket.removeIf(entry -> entry.key.equals(key));
        }
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }


}


public class MyOwnHashMapRunner {
    public static void main(String[] args) {
//        MyOwnHashMap<String, Integer> map = new MyOwnHashMap<>();
//        map.put("apple", 1);
//        map.put("banana", 2);
//
//        System.out.println(map.get("apple"));   // 1
//        System.out.println(map.get("banana"));  // 2
//
//        map.put("apple", 100);
//        System.out.println(map.get("apple"));   // 100
//
//        System.out.println(map.containsKey("banana")); // true
//
//        map.remove("banana");
//        System.out.println(map.containsKey("banana")); // false

        MyOwnHashMap<Integer, String> map = new MyOwnHashMap<>();
        map.put(1, "apple");
        map.put(2, "banana");

        System.out.println(map.get(1));   // Apple
        System.out.println(map.get(2));  // Banana

        map.put(1, "Kiwi");
        System.out.println(map.get(1));   // Kiwi

        System.out.println(map.containsKey(2)); // true

        map.remove(2);
        System.out.println(map.containsKey(2)); // false

    }
}
