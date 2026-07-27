public class Book {
    String title="NA";
    String author="NA";
    int price=0;
    Book()
    {}
    Book(String t, String a){
        title=t;
        author=a;
        
    }
    Book(String t, String a, int p){
        title=t;
        author=a;
        price=p;
    }
    void print()
    {
        System.out.println("Title:"+title);
        System.out.println("Author:"+author);
        System.out.println("Price:"+price);
    }
    public static void main(String args[]){
        System.out.println("Default Constructor");
        Book obj2 = new Book();
        obj2.print();
        System.out.println("\nParameterized Constructor 1");
        Book obj = new Book("Harry Potter","JK Rowling");
        obj.print();
        System.out.println("\nParameterized Constructor 2");
        Book obj1 = new Book("Fault in our Stars","John Green", 599);
        obj1.print();
    }
    
}
