package acn;

import java.util.concurrent.ConcurrentHashMap;


public class ConcurrentHashmapDemo {

    public static void main(String[] args) {
        // Create a ConcurrentHashMap
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Put some values
        map.put("apple", 10);
        map.put("banana", 20);

        // Get value
        System.out.println("apple = " + map.get("apple"));

        // Update value atomically
        map.computeIfPresent("apple", (key, val) -> val + 5);

        // Check updated value
        System.out.println("apple after update = " + map.get("apple"));

        // Concurrent read/write from multiple threads example
        Runnable writer = () -> {
            try {
                Thread.sleep(10);  // simulate delay for adding keys
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 1000; i++) {
                map.put("key" + i, i);
            }
        };

        Runnable reader = () -> {
            try {
                Thread.sleep(9);  // slightly longer delay to catch the missing keys
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 1000; i++) {
                System.out.println("Reading key" + i + ": " + map.get("key" + i));
            }
        };

        Thread t1 = new Thread(writer);
        Thread t2 = new Thread(reader);

        t1.start();
        t2.start();
    }
}

