public class mingap {

    public static int minGap(int[] array, int n) {
      if (n < 2) {
        return 0;
      }
  
      // Initialize the minimum gap to be the difference between the first two elements
      int minGap = array[1] - array[0];
      System.out.println("Gap between " + array[0] + " and " + array[1] + ": " + minGap);
  
      // Iterate through the array, starting from the second element
      for (int i = 2; i < n; i++) {
        // Update the minimum gap if the current gap is smaller
        int currentGap = array[i] - array[i - 1];
        minGap = Math.min(minGap, currentGap);
        System.out.println("Gap between " + array[i - 1] + " and " + array[i] + ": " + currentGap);
      }
  
      return minGap;
    }
  
    public static void main(String[] args) {
      int[] array = {1, 3, 6, 7, 12};
      int minGapValue = minGap(array, array.length);
      System.out.println("\nMinimum Gap: " + minGapValue);
    }
  }
  