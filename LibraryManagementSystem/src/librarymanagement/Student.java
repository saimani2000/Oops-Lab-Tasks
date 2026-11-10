package librarymanagement;

public class Student {

    String studentId;
    String studentName;

    public Student(String studentId, String studentName) {

        this.studentId = studentId;
        this.studentName = studentName;
    }

    public void displayStudent() {

        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentName);
    }
}