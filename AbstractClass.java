
    abstract class Shape{
        abstract void draw();
        void message()
        {
            System.out.println("Drawing shape");
        }
    }
    class Circle extends Shape{
        void draw(){
            System.out.println("Drawing Shape");
        }
        void message(){
            System.out.println("Drawing shape:Circle");  //method overriding and only works with inheritance
        }
    }
public class AbstractClass {
    public static void main(String args[]){
        Circle c = new Circle();
        c.message();   //circle method executes due to method overriding
        c.draw();

    }
}
