public class Student {
    int roll_number;
    String name;
    Student()
    {

    }
    Student(int r,String n){
        roll_number=r;
        name=n;
    }
    void print()
    {
        System.out.println("Name:"+name);
        System.out.println("Roll Number:"+roll_number);
    }
    public static void main(String args[]){
        Student obj = new Student();
        obj.print();
        Student obj1 = new Student(210, "Upali");
        obj1.print();
    }
}
