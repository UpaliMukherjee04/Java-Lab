import library.Book;

public class MainApp {
    public static void main(String[] args) {

        Book b = new Book(1, "Java Basics", "James Gosling", 499.99);

        System.out.println("---- Book Details ----");
        b.display();
    }
}