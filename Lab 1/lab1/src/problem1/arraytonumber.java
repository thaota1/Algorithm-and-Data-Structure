public class arraytonumber {
    public static int arrayToNumber(int[] arr) {
        int result = 0;
        for (int i : arr) {
            result = result * 10 + i;
        }
        return result;
    }
    public static void main(String[] args) {
    // example 
    int[] digits = {1, 2, 3, 4, 5};
    int number = arrayToNumber(digits);
    System.out.println("Converted number: " + number);
    }
}
