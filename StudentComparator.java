package acn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.*;

class StudentComparatorLogic implements Comparator<Student> {

    // Compare 1st marks , if same, then compare name
    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getTotalMarks() != s2.getTotalMarks()) {
            return Integer.compare(
                    s1.getTotalMarks(), s2.getTotalMarks());
        }
        return s1.getName().compareTo(s2.getName());
    }
}



public class StudentComparator {

    public static void main(String[] args) {
        List<Student> stList = Arrays.asList(
                new Student("sagar", 39),
                new Student("sagar", 45),
                new Student("John", 39),
                new Student("Mark", 56),
                new Student("John", 86)
        );

        stList.sort(new StudentComparatorLogic());

        for (Student student : stList) {
            System.out.println(student);
        }



    }
}