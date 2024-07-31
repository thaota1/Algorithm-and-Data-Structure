import java.util.Scanner;

public class problem7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String reversed = reverseString(input);
        System.out.println("Reversed string: " + reversed);

        scanner.close();
    }

    public static String reverseString(String str) {
        // Base case: if the string is empty or has only one character, return the string itself
        if (str == null || str.length() <= 1) {
            return str;
        }
        // Recursive case: reverse the substring excluding the first character, then append the first character at the end
        else {
            return reverseString(str.substring(1)) + str.charAt(0);
        }
    }
}

