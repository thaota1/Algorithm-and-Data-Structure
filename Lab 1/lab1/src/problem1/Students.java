/*
 * Reading student records from a file, generating Student objects, counting and averaging
 * Suggested exercises:
 * - Use grade to determine the type of the student: excellent (> 89), ok [60,89], and failure (< 60)
 * - Define an enum type {excellent, ok, failure} and use it to print the student type
 * - Do counting and averaging within each student type (excellent, ok, and failure)
 * - Count students by using a static variable in class Student
 */
import java.util.Scanner;
import java.io.*;

public class Students {
    public static void main(String[] args) throws IOException {
        String firstName, lastName;
        int grade;
        int total = 0, count = 0;

        // Read student records from the file
        Scanner fileInput = new Scanner(new File("C://Users/ADMIN/Downloads/Algorithm-and-Data-Structure/Lab 1/lab1/src/problem1/students.txt"));
        while (fileInput.hasNext()) {
            firstName = fileInput.next();
            lastName = fileInput.next();
            grade = fileInput.nextInt();

            // Create a new Student object
            Student st = new Student(firstName, lastName, grade);

            // Print student details
            System.out.println(st);

            // Update total grades and count for overall average
            total = total + grade;
            count++;
        }fileInput.close();

        // Calculate overall average
        double average = (double) total / count;
        System.out.println("\nThere are " + count + " students with an overall average grade of " + average);

        // Print statistics for each category
        Student.printStatistics();
    }
}