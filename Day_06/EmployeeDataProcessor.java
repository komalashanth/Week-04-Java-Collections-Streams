import java.util.*;
import java.util.stream.*;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString() {
        return id + " " + name + " " + department + " $" + salary;
    }

    public double getSalary() {
        return salary;
    }
}

public class EmployeeDataProcessor {

    public static void processEmployees(List<Employee> employees) {
        List<Employee> filteredAndSorted = employees.stream()
            .filter(e -> e.department.equals("Engineering") && e.salary > 80000)
            .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
            .collect(Collectors.toList());

        Map<String, List<Employee>> groupedByDept = filteredAndSorted.stream()
            .collect(Collectors.groupingBy(e -> e.department));

        Map<String, Double> averageSalaryByDept = groupedByDept.entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue().stream()
                        .mapToDouble(emp -> emp.salary)
                        .average()
                        .orElse(0.0)
            ));

        System.out.println("Filtered and Sorted Employees:");
        filteredAndSorted.forEach(System.out::println);

        System.out.println("\nAverage Salary by Department:");
        averageSalaryByDept.forEach((dept, avgSal) ->
            System.out.println(dept + ": $" + avgSal));
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "Engineering", 95000),
            new Employee(2, "Bob", "HR", 70000),
            new Employee(3, "Charlie", "Engineering", 85000),
            new Employee(4, "David", "Engineering", 78000),
            new Employee(5, "Eve", "Sales", 90000)
        );

        processEmployees(employees);
    }
}
