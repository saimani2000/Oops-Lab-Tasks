package librarymanagement;

public class Librarian {

    Library library;

    public Librarian(Library library) {

        this.library = library;
    }

    public void approveBookIssue(Student student, int bookId) {

        System.out.println("\nLIBRARIAN APPROVAL");

        library.issueBook(student, bookId);
    }

    public void collectFine(int bookId) {

        library.collectFine(bookId);
    }

    public void generateReport() {

        library.generateReport();
    }
}