import java.util.Scanner;

public class RecursiveSum {
    // Recursive method to calculate the sum 1 + 1/2 + 1/3 + ... + 1/n
    public static double sum(int n) {
        // Base case: when n is 1, return 1
        if (n == 1) {
            return 1.0;
        }
        // Recursive case: return 1/n + sum of previous terms
        return 1.0 / n + sum(n - 1);
    }

    public static void main(String[] args) {
        // Create a scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the value of n
        System.out.print("Enter the value of n (n > 1): ");
        int n = scanner.nextInt();

        // Ensure n is greater than 1
        if (n <= 1) {
            System.out.println("Please enter a value greater than 1.");
        } else {
            // Call the sum method and display the result
            System.out.println("Sum: " + sum(n));
        }
        // Close the scanner
        scanner.close();
    }
}
