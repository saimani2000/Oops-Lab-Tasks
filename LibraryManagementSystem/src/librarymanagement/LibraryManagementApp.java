package librarymanagement;

import java.util.Scanner;

public class LibraryManagementApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library library = new Library();

        Librarian librarian = new Librarian(library);

        int choice;

        do {

            System.out.println("\n================================");
            System.out.println("     LIBRARY MANAGEMENT SYSTEM");
            System.out.println("================================");

            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Show Available Books");
            System.out.println("4. Approve Book Issue");
            System.out.println("5. Return Book");
            System.out.println("6. Collect Fine");
            System.out.println("7. Generate Report");
            System.out.println("8. Show Issued Books");
            System.out.println("9. Due Date Reminder");
            System.out.println("0. Exit");

            System.out.print("\nEnter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Book ID: ");

                    int bookId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Book Name: ");

                    String bookName = sc.nextLine();

                    System.out.print("Enter Author Name: ");

                    String author = sc.nextLine();

                    Book book = new Book(bookId, bookName, author);

                    library.addBook(book);

                    break;

                case 2:

                    System.out.print("Enter Book ID: ");

                    int searchId = sc.nextInt();

                    library.searchBook(searchId);

                    break;

                case 3:

                    library.showAvailableBooks();

                    break;

                case 4:

                    System.out.print("Enter Student ID: ");

                    String studentId = sc.next();

                    sc.nextLine();

                    System.out.print("Enter Student Name: ");

                    String studentName = sc.nextLine();

                    Student student = new Student(studentId, studentName);

                    System.out.print("Enter Book ID to issue: ");

                    int issueId = sc.nextInt();

                    librarian.approveBookIssue(student, issueId);

                    break;

                case 5:

                    System.out.print("Enter Book ID to return: ");

                    int returnId = sc.nextInt();

                    library.returnBook(returnId);

                    break;

                case 6:

                    System.out.print("Enter Book ID: ");

                    int fineId = sc.nextInt();

                    librarian.collectFine(fineId);

                    break;

                case 7:

                    librarian.generateReport();

                    break;

                case 8:

                    library.showIssuedBooks();

                    break;

                case 9:

                    library.dueDateReminder();

                    break;

                case 0:

                    System.out.println("Thank you for using Library Management System!");

                    break;

                default:

                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}