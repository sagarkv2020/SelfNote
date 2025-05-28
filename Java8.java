package leetcode;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Java8 {
    String name;
    double salary;

    public Java8(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() { return "Employee{" +  "name='" + name + '\'' +  ", salary=" + salary + '}';    }

    public static void main(String[] args) {
        List<Java8> empList = Arrays.asList(
                new Java8("John", 60000),  new Java8("Ram", 29999),  new Java8("Wendy", 90000),  new Java8("Jackie", 90000)    );

//Calculate the total salary of employees.
        double totalSalary = empList.stream().mapToDouble(Java8::getSalary).sum();
        System.out.println(totalSalary);


        //      Find the highest salary and the employee(s) who earn it.
        double highest = empList.stream().mapToDouble(Java8::getSalary).max().orElse(0);
        empList.stream().filter(e -> e.getSalary() == highest).forEach( e -> System.out.println(e.getName()+ " has highestv salary = "+e.getSalary()));
        System.out.println(highest);
        // Find the highest salary and employees who earn it using a single stream
        empList.stream().
                mapToDouble(Java8::getSalary).max().
                ifPresent(highestSalary -> empList.stream().
                        filter(e -> e.getSalary() == highestSalary).
                        forEach( e -> System.out.println(e.getName()+" has Highest Salary")
        ));

//      Filter employees by salary range (e.g., employees with salary > $50,000).
        empList.stream().filter(e -> e.getSalary() > 50000).forEach( e -> System.out.println(e.getName()+ " has  salary  GT 50K = "+e.getSalary()));

//      Sort employees by salary in descending order.
        System.out.println("AAAA");
       // empList.stream().filter(e -> e.getSalary() == highest).forEach( e -> System.out.println(e.getName()+ " has highest salary = "+e.getSalary()));
        // Sorting employees in descending order of salary
        List<Java8> sortedEmployees = empList.stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .collect(Collectors.toList());

        sortedEmployees.forEach( x -> {System.out.println(x.getName() +"  "+x.getSalary());});

        System.out.println("BBB");
        // Sort the employees alphabetically by their name
        List<Java8> sortedEmployeesName = empList.stream()
                .sorted(Comparator.comparing(Java8::getName))  // Sort by name in ascending order
                .collect(Collectors.toList());
        sortedEmployeesName.forEach( x -> {System.out.println(x.getName() +"  "+x.getSalary());});
    }

}