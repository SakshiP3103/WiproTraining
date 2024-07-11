import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


interface StudentManagement {
    void createStudentRecord(String name, int age, String id);
    void getStudentRecord(String id);
}

class StudentManagmentSystem {
    String name;
    int age;
    String id;

    StudentManagmentSystem(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

}


class StudentManager implements StudentManagement {
   List<StudentManagmentSystem> students = new ArrayList<>();

   
    public void createStudentRecord(String name, int age, String id) {
        StudentManagmentSystem student = new StudentManagmentSystem(name, age, id);
        students.add(student);
        System.out.println("Student record created: " + student);
    }


    public void getStudentRecord(String id) {
        for (StudentManagmentSystem student : students) {
            if (student.id.equals(id)) {
                System.out.println("Student record found: " + student);
                return;
            }
        }
        System.out.println("Student record not found for ID: " + id);
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create Student Record");
            System.out.println("2. Get Student Record");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter student ID: ");
                    String id = scanner.nextLine();
                    manager.createStudentRecord(name, age, id);
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    id = scanner.nextLine();
                    manager.getStudentRecord(id);
                    break;
                case 3:
                    System.out.println("Your id already exists");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid, Please try again.");
            }
        }
    }
}
