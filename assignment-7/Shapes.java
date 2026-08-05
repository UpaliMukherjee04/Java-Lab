import java.util.*;
interface Shape{
     void area();
    
}
class Circle implements Shape{
    Scanner sc = new Scanner(System.in);
    public void area(){
        System.out.print("Enter radius of Circle:");
        int radius=sc.nextInt();
        System.out.println("Area of Circle:"+3.14*radius*radius);
         
    }
}
class Rectangle implements Shape{
    public void area(){
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter length:");
    int length=sc.nextInt();
    System.out.print("Enter breadth");
    int breadth = sc.nextInt();
    System.out.println("Area of rectangle="+length*breadth);
    sc.close();
    }
    
}

public class Shapes {
    public static void main(String args[]){
        Circle c= new Circle();
        c.area();
        Rectangle r= new Rectangle();
        r.area();
      
    }
    
}
