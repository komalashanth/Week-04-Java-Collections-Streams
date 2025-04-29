import java.io.*;
import java.util.*;

// Employee class must implement Serializable
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

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

    @Override
    public String toString() {
        return "Employee [ID=" + id + ", Name=" + name + ", Department=" + department + ", Salary=" + salary + "]";
    }
}

public class EmployeeSerialization {

    private static final String FILE_NAME = "employees.ser";

    // Serialize the employee list to a file
    public static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(employees);
            System.out.println("Employee list has been serialized to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error during serialization:");
            e.printStackTrace();
        }
    }

    // Deserialize the employee list from a file
    public static List<Employee> deserializeEmployees() {
        List<Employee> employees = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (List<Employee>) in.readObject();
            System.out.println("Employee list has been deserialized from " + FILE_NAME);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization:");
            e.printStackTrace();
        }
        return employees;
    }

    public static void main(String[] args) {
        // Create a list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Alice", "HR", 50000));
        employees.add(new Employee(102, "Bob", "IT", 65000));
        employees.add(new Employee(103, "Charlie", "Finance", 70000));

        // Serialize the list
        serializeEmployees(employees);

        // Deserialize and display the list
        List<Employee> retrievedEmployees = deserializeEmployees();
        if (retrievedEmployees != null) {
            for (Employee emp : retrievedEmployees) {
                System.out.println(emp);
            }
        }
    }
}

