import java.util.Scanner;

public class RecursiveArrayOperations {

    // Recursive function to find the minimum element in the array
    public static int findmin(int a[], int n) {
        // Base case: If there is only one element, return it
        if (n == 1) {
            return a[0];
        }

        // Recursive case: Find the minimum in the rest of the array
        int minOfRest = findmin(a, n - 1);

        // Return the minimum of the current element and the rest
        return Math.min(a[n - 1], minOfRest);
    }

    // Recursive function to find the sum of elements in the array
    public static int findsum(int a[], int n) {
        // Base case: If there is only one element, return it
        if (n == 1) {
            return a[0];
        }

        // Recursive case: Add the current element to the sum of the rest
        return a[n - 1] + findsum(a, n - 1);
    }

    public static void main(String[] args) {
        // Create a scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the size of the array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        // Initialize the array
        int[] array = new int[n];

        // Ask the user to input the array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Find and print the minimum element
        System.out.println("Minimum element: " + findmin(array, n));

        // Find and print the sum of the array
        System.out.println("Sum of elements: " + findsum(array, n));

        // Close the scanner
        scanner.close();
    }
}

