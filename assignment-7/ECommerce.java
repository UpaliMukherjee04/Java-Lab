interface Product {
    void display();
}
class ProductDetails {
    int id;
    String name;
    double price;
}

class Electronic extends ProductDetails implements Product {

    public void display() {
        id = 101;
        name = "Laptop";
        price = 65000;

        System.out.println("Electronic Product");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}

class Clothing extends ProductDetails implements Product {

    public void display(){
        id = 102;
        name = "T-Shirt";
        price = 999;

        System.out.println("\nClothing Product");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}

class Grocery extends ProductDetails implements Product {

    public void display() {
        id = 103;
        name = "Rice";
        price = 1200;

        System.out.println("\nGrocery Product");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}

// Main Class
public class ECommerce{
    public static void main(String[] args) {

        Electronic e = new Electronic();
        Clothing c = new Clothing();
        Grocery g = new Grocery();

        e.display();
        c.display();
        g.display();
    }
}