package acn;

import java.util.*;

/*
Goals:
-No duplicate elements
-Underlying structure: can use a HashMap for simplicity
-Core methods:-> add, remove, contains, size, toString
*/
class MyOwnSet<T> implements Iterable<T> {

    private static final Object DUMMY =  new Object();;
    private HashMap<T, Object> map;


    public MyOwnSet() {
        map = new HashMap<>();
    }

    public boolean add(T element){
        return map.put(element, DUMMY) == null;
    }

    public boolean remove(T element){
        return map.remove(element) != null;
    }

    public boolean contains(T element){
        return map.containsKey(element);
    }

    public int size(){
        return map.size();
    }

    public void clear(){
        map.clear();
    }
    @Override
    public String toString() {
        return map.keySet().toString();
    }

    @Override
    public Iterator<T> iterator() {
        return map.keySet().iterator();
    }

}

public class MyOwnSetRunner {
    public static void main(String[] args) {
        MyOwnSet<String> set = new MyOwnSet<>();
        set.add("apple");
        set.add("banana");
        set.add("apple"); // duplicate

        System.out.println(set);          // [apple, banana]
        System.out.println(set.contains("banana")); // true
        set.remove("apple");
        System.out.println(set);          // [banana]
        System.out.println("Size: " + set.size());  // 1
    }
}
