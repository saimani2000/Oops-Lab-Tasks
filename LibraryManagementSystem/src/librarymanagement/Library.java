package librarymanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;

public class Library {

    ArrayList<Book> books = new ArrayList<>();

    Map<String, Book> issuedBooks = new HashMap<>();

    Map<String, IssueRecord> issueRecords = new HashMap<>();

    // Add Book
    public void addBook(Book book) {

        for (Book b : books) {

            if (b.bookId == book.bookId) {

                System.out.println("Book ID already exists!");
                return;
            }
        }

        books.add(book);

        System.out.println("Book added successfully!");
    }

    // Search Book
    public void searchBook(int id) {

        for (Book book : books) {

            if (book.bookId == id) {

                book.displayBook();
                return;
            }
        }

        System.out.println("Book not found!");
    }

    // Show Available Books
    public void showAvailableBooks() {

        boolean found = false;

        System.out.println("\nAVAILABLE BOOKS");

        for (Book book : books) {

            if (book.available) {

                book.displayBook();
                found = true;
            }
        }

        if (!found) {

            System.out.println("No books available!");
        }
    }

    // Issue Book
    public void issueBook(Student student, int id) {

        for (Book book : books) {

            if (book.bookId == id) {

                if (book.available) {

                    book.available = false;

                    String key = String.valueOf(id);

                    issuedBooks.put(key, book);

                    IssueRecord record = new IssueRecord(student, book);

                    issueRecords.put(key, record);

                    System.out.println("Book issued successfully!");

                    System.out.println("Issue Date: " + record.issueDate);

                    System.out.println("Due Date: " + record.dueDate);

                } else {

                    System.out.println("Book is already issued!");
                }

                return;
            }
        }

        System.out.println("Book not found!");
    }

    // Return Book
    public void returnBook(int id) {

        String key = String.valueOf(id);

        if (issuedBooks.containsKey(key)) {

            IssueRecord record = issueRecords.get(key);

            long fine = record.calculateFine();

            if (fine > 0 && !record.finePaid) {

                System.out.println("Please pay the fine first!");

                System.out.println("Fine Amount: Rs." + fine);

                return;
            }

            System.out.println("Book returned successfully!");

            System.out.println("Student Name: " + record.student.studentName);

            issuedBooks.remove(key);

            issueRecords.remove(key);

            record.book.available = true;

        } else {

            System.out.println("Book is not issued!");
        }
    }

    // Collect Fine
    public void collectFine(int id) {

        String key = String.valueOf(id);

        if (issueRecords.containsKey(key)) {

            IssueRecord record = issueRecords.get(key);

            long fine = record.calculateFine();

            if (fine > 0) {

                if (!record.finePaid) {

                    System.out.println("Fine Amount: Rs." + fine);

                    record.finePaid = true;

                    System.out.println("Fine collected successfully!");

                } else {

                    System.out.println("Fine already paid!");
                }

            } else {

                System.out.println("No fine to collect!");
            }

        } else {

            System.out.println("Issue record not found!");
        }
    }

    // Generate Library Report
    public void generateReport() {

        int availableCount = 0;

        for (Book book : books) {

            if (book.available) {

                availableCount++;
            }
        }

        System.out.println("\n===== LIBRARY REPORT =====");

        System.out.println("Total Books: " + books.size());

        System.out.println("Issued Books: " + issuedBooks.size());

        System.out.println("Available Books: " + availableCount);

        System.out.println("==========================");
    }

    // Show Issued Books
    public void showIssuedBooks() {

        if (issueRecords.isEmpty()) {

            System.out.println("No books are currently issued!");

            return;
        }

        System.out.println("\nISSUED BOOK DETAILS");

        for (IssueRecord record : issueRecords.values()) {

            record.displayRecord();
        }
    }

    // Due Date Reminder
    public void dueDateReminder() {

        boolean found = false;

        LocalDate today = LocalDate.now();

        for (IssueRecord record : issueRecords.values()) {

            if (!today.isBefore(record.dueDate)) {

                System.out.println("\nDUE DATE REMINDER");

                System.out.println("Student: " + record.student.studentName);

                System.out.println("Book: " + record.book.bookName);

                System.out.println("Due Date: " + record.dueDate);

                System.out.println("Fine: Rs." + record.calculateFine());

                found = true;
            }
        }

        if (!found) {

            System.out.println("No due date reminders!");
        }
    }
}