import student.Student;
import faculty.Faculty;

public class Main{
    public static void main(String[] args) {

        Student s = new Student(210, "Upali");
        Faculty f = new Faculty(201, "Dr. Sharma");

        System.out.println("---- Student Details ----");
        s.display();

        System.out.println("\n---- Faculty Details ----");
        f.display();
    }
}