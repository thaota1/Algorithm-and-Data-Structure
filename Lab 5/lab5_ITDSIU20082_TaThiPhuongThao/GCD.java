public class GCD {

    public static int gcd(int p, int q) {
        // Base case: if q is 0, the GCD is p
        if (q == 0) {
            return p;
        }

        // Recursive case: call gcd with q and p % q
        return gcd(q, p % q);
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("Enter the first integer: ");
        int p = scanner.nextInt();

        System.out.print("Enter the second integer: ");
        int q = scanner.nextInt();

        System.out.println("The GCD of " + p + " and " + q + " is: " + gcd(p, q));

        scanner.close();
    }
}
