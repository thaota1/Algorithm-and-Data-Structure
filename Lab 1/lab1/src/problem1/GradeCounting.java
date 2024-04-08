import java.util.Scanner;
public class GradeCounting {
    

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numStudents;

        System.out.print("Enter the number of students: ");
        numStudents = scan.nextInt();

        // Arrays to store student names and grades
        String[] firstNames = new String[numStudents];
        String[] lastNames = new String[numStudents];
        int[] grades = new int[numStudents];

        // Input student information
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student first name: ");
            firstNames[i] = scan.next();
            
            System.out.print("Enter student last name: ");
            lastNames[i] = scan.next();
            
            System.out.print("Enter student grade: ");
            grades[i] = scan.nextInt();
        }

        // Counting and averaging for different student types
        int excellentCount = 0, okCount = 0, failureCount = 0;
        double excellentSum = 0, okSum = 0, failureSum = 0;

        for (int i = 0; i < numStudents; i++) {
            if (grades[i] > 89) {
                excellentCount++;
                excellentSum += grades[i];
            } else if (grades[i] >= 60 && grades[i] <= 89) {
                okCount++;
                okSum += grades[i];
            } else {
                failureCount++;
                failureSum += grades[i];
            }
        }

        //  students' last names
        System.out.println("Students with their last names:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println(lastNames[i]);
        }

        // Calculating averages
        double excellentAvg = excellentCount == 0 ? 0 : excellentSum / excellentCount;
        double okAvg = okCount == 0 ? 0 : okSum / okCount;
        double failureAvg = failureCount == 0 ? 0 : failureSum / failureCount;

        // Displaying results
        System.out.println("Number of students with excellent grades: " + excellentCount);
        System.out.println("Average grade of excellent students: " + excellentAvg);
        System.out.println("Number of students with ok grades: " + okCount);
        System.out.println("Average grade of ok students: " + okAvg);
        System.out.println("Number of students with failure grades: " + failureCount);
        System.out.println("Average grade of failure students: " + failureAvg);

        scan.close();
    }
}
