import java.util.Scanner;
public class problem5 {

    public static int findSum(int[] a, int n) {
        // Base case: if array size is 0, return 0
        if (n == 0) {
            return 0;
        }
        // Recursive case: sum of all elements in the array is the first element + sum of elements in the rest of the array
        else {
            return a[n - 1] + findSum(a, n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter the size of the array: ");
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();

            int[] a = new int[n];

            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            int result = findSum(a, n);
            System.out.printf("The sum of all elements in the array is: %d%n", result);
        }
    }
}

