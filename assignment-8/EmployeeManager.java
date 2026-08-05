//1.Create an Employee and Manager program where Manager accesses Employee details
//using super keyword. 

class Employee{
    String name;
    String id;
    float salary;

    Employee(String name, String id, float salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    void displayEmployee(String name, String id, float salary){
        System.out.println("ID:"+id);
        System.out.println("Name:"+name);
        System.out.println("Salary:"+salary);
    }
}
class Manager extends Employee{
    String dept;
    Manager(String name, String id, int salary){
        super(name, id, salary);
        this.dept = "General";
    }
    Manager(String name, String id, float salary, String dept){
        super(name, id, salary);
        this.dept=dept;
    }
    void display(){
       

        System.out.println("\n---Employee Details---\n");
        System.out.println("Employee id:"+id);
        System.out.println("Name:"+name);
        System.out.println("Salary:"+salary);
        System.out.println("Department:"+dept);
    }
}
public class EmployeeManager {
    public static void main(String args[]){
        Manager m = new Manager("Amit", "A101", 500000, "sales");
        m.display();
    }
}
