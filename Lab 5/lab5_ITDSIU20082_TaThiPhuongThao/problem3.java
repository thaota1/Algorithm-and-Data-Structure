import java.util.Scanner;

public class problem3{

        public static int sum(int n) {
            // Base case: if n is 0, return 0
            if (n == 0) {
                return 0;
            }
            // Recursive case: sum of numbers from 1 to n is n + sum of numbers from 1 to n-1
            else {
                return n + sum(n - 1);
            }
        }

    

    public static void main(String[] args) {
        int n;
        System.out.print("Enter a positive integer: ");
        try (Scanner scanner = new Scanner(System.in)) {
            n = scanner.nextInt();
        }
        int result = sum(n);
        System.out.printf("The sum of numbers from 1 to %d is: %d%n", n, result);
    }
}

