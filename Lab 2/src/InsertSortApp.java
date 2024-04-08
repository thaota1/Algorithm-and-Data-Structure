public class InsertSortApp {
   public static void insertionSort(int[] arr) {
       int n = arr.length;
       int comparisons = 0;
       int totalPasses = 0;

       for (int i = 1; i < n; i++) {
           int key = arr[i];
           int j = i - 1;

           // Move elements of arr[0..i-1], that are greater than key, to one position ahead of their current position
           while (j >= 0 && arr[j] > key) {
               arr[j + 1] = arr[j];
               j--;
               comparisons++;
           }
           arr[j + 1] = key;

           // Display array after each pass of the outer loop
           System.out.print("Array after pass " + i + ": ");
           for (int k = 0; k <= i; k++) {
               System.out.print(arr[k] + " ");
           }
           System.out.println();
           totalPasses++;
       }

       // Display number of passes of the inner loop and total number of passes
       System.out.println("Total passes of the inner loop: " + (totalPasses - 1)); // Subtract 1 for the initial pass
       System.out.println("Total number of passes: " + totalPasses);

       // Display estimated algorithm's complexity
       int complexity = n * (n - 1) / 4;
       System.out.println("Estimated algorithm's complexity: " + complexity);
   }

   public static void main(String[] args) {
       int[] arr = {64, 34, 25, 12, 22, 11, 90};
       insertionSort(arr);
       System.out.print("Sorted array: ");
       for (int i : arr) {
           System.out.print(i + " ");
       }
       System.out.println();
   }
}
