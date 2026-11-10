package librarymanagement;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class IssueRecord {

    Student student;
    Book book;

    LocalDate issueDate;
    LocalDate dueDate;

    boolean finePaid;

    public IssueRecord(Student student, Book book) {

        this.student = student;
        this.book = book;

        issueDate = LocalDate.now();
        dueDate = issueDate.plusDays(14);

        finePaid = false;
    }

    public long calculateFine() {

        LocalDate today = LocalDate.now();

        if (today.isAfter(dueDate)) {

            long days = ChronoUnit.DAYS.between(dueDate, today);

            return days * 5;
        }

        return 0;
    }

    public void displayRecord() {

        System.out.println("Student ID: " + student.studentId);
        System.out.println("Student Name: " + student.studentName);

        System.out.println("Book ID: " + book.bookId);
        System.out.println("Book Name: " + book.bookName);

        System.out.println("Issue Date: " + issueDate);
        System.out.println("Due Date: " + dueDate);

        System.out.println("Fine Amount: Rs." + calculateFine());

        System.out.println("--------------------------");
    }
}