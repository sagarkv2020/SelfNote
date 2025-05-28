package acn;

import java.util.Arrays;
import java.util.*;
import java.util.List;

class Student implements Comparable<Student> {
    private String name;
    private int totalMarks;

    // constructor, getters
    public Student(String name, int totalMarks) {
        this.name = name;
        this.totalMarks = totalMarks;
    }

    public String getName() { return name; }
    public int getTotalMarks() { return totalMarks; }

    @Override
    public String toString() {
        return name + ": =" + totalMarks;
    }

    @Override
    public int compareTo(Student s) {
        if (this.totalMarks != s.totalMarks) {
            return Integer.compare(
                    this.totalMarks, s.totalMarks);
        }
        return this.name.compareTo(s.name);
    }
}

class Main {

    public static void main(String[] args) {

        List<Student> stList = Arrays.asList(
                new Student("sagar", 39),
                new Student("sagar", 45),
                new Student("John", 39),
                new Student("Mark", 56),
                new Student("John", 86)
        );

        Collections.sort(stList);

        for (Student student : stList) {
            System.out.println(student);
        }
    }
}
