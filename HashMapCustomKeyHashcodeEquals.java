package acn;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Override equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // same object reference
        if (o == null || !(o instanceof Employee)) return false;

        Employee other = (Employee) o;
        return this.id == other.id && Objects.equals(this.name, other.name);
    }

    // Override hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "'}";
    }
}

public class HashMapCustomKeyHashcodeEquals {
    public static void main(String[] args) {
        Map<Employee, String> map = new HashMap<>();

        Employee e1 = new Employee(1, "Alice");
        Employee e2 = new Employee(2, "Bob");
        Employee e3 = new Employee(1, "Alice"); // same id and name as e1

        map.put(e1, "Developer");
        map.put(e2, "Manager");

        System.out.println("Role for e1: " + map.get(e1)); // Developer
        System.out.println("Role for e3: " + map.get(e3)); // Developer - because e1.equals(e3) is true

        System.out.println("Map size: " + map.size()); // 2, because e1 and e3 are considered equal keys
    }
}

