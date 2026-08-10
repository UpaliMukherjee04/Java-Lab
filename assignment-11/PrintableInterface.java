interface Printable{
    void displayDetails(String a, int b, float c);
}

class Student implements Printable{
    public void displayDetails(String sname, int age, float gpa){
        System.out.println("Student name"+sname);
        System.out.println("Student age:"+age);
        System.out.println("Student gpa:"+gpa);
    }
}
class Employee implements Printable{
    public void displayDetails(String ename, int age, float salary){
        System.out.println("Employee name:"+ename);
        System.out.println("Employee age:"+age);
        System.out.println("Employee salary:"+salary);
    }
}

public class PrintableInterface {
    public static void main(String args[]){
        Student s = new Student();
        System.out.println("\nStudent details:");
        s.displayDetails("Upali", 19, 8.6f);
        Employee e = new Employee();
        System.out.println("\nEmployee Details:");
        e.displayDetails("Ajay Gupta", 34, 32000.00f);

    }
}
