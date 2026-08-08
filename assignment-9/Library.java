class Book {
    private final String isbn;
    private String title;
    private String author;
    private double price;

    public Book(String isbn, String title, String author, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayBookDetails() {
        System.out.println("Book Deatils:");
        System.out.println("ISBN:   " + this.isbn);
        System.out.println("Title:  " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("Price:  $" + this.price);
    }
}

public class Library{
    public static void main(String[] args) {
        Book book1 = new Book("978-0134685991", "Effective Java", "Joshua Bloch", 45.00);
        book1.displayBookDetails();
    }
}