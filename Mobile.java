public class Mobile {
    String color;
    String model;
    int battery;
    double price;
    Mobile(){

    }
    Mobile(String c,String m,int b,double p){
        color=c;
        model=m;
        battery=b;
        price=p;
    }
    Mobile(Mobile a){
        color=a.color;
        model=a.model;
        battery=a.battery;
        price=a.price;
    }
    void print()
    {
        System.out.println("Color:"+color);
        System.out.println("Model:"+model);
        System.out.println("Battery:"+battery);
        System.out.println("Price:"+price);

    }
    public static void main(String args[]){
        System.out.println("\nParameterized Constructor");
        Mobile obj = new Mobile("black","Vivo",6000,23000.00);
        obj.print();
        System.out.println("\nCopy Constructor");
        Mobile obj1= new Mobile(obj);
        obj1.print();
    
    }
}
