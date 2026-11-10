package librarymanagement;

public class Book {

    int bookId;
    String bookName;
    String author;
    boolean available;

    public Book(int bookId, String bookName, String author) {

        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.available = true;
    }

    public void displayBook() {

        System.out.println("Book ID: " + bookId);
        System.out.println("Book Name: " + bookName);
        System.out.println("Author: " + author);

        if (available) {
            System.out.println("Status: Available");
        } else {
            System.out.println("Status: Issued");
        }

        System.out.println("--------------------------");
    }
}