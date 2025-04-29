import java.io.*;

public class StudentDataStream {

    private static final String FILE_NAME = "students.dat";

    // Method to write student data to a binary file
    public static void writeStudentData() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            // Example student data
            dos.writeInt(101);
            dos.writeUTF("Alice");
            dos.writeDouble(3.8);

            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(3.5);

            dos.writeInt(103);
            dos.writeUTF("Charlie");
            dos.writeDouble(3.9);

            System.out.println("Student data has been written to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error writing student data:");
            e.printStackTrace();
        }
    }

    // Method to read student data from the binary file
    public static void readStudentData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            System.out.println("\nReading student data:");
            while (dis.available() > 0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll: " + roll + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading student data:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        writeStudentData();
        readStudentData();
    }
}

