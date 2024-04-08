public class SelectSortApp {
   public static void selectionSort(int[] arr) {
       int n = arr.length;
       int comparisons = 0;
       int swaps = 0;

       for (int i = 0; i < n - 1; i++) {
           int minIndex = i;
           for (int j = i + 1; j < n; j++) {
               comparisons++;
               if (arr[j] < arr[minIndex]) {
                   minIndex = j;
               }
           }

           // Swap the found minimum element with the first element
           if (minIndex != i) {
               int temp = arr[i];
               arr[i] = arr[minIndex];
               arr[minIndex] = temp;
               swaps++;
           }

           // Display array after inner loop
           System.out.print("Array after inner loop " + (i + 1) + ": ");
           for (int k : arr) {
               System.out.print(k + " ");
           }
           System.out.println();
       }
       
       // Display number of comparisons after the inner loop and the total number of comparisons
       System.out.println("Total number of comparisons: " + comparisons);
       System.out.println("Total number of swaps: " + swaps);
   }

   public static void main(String[] args) {
       int[] arr = {64, 34, 25, 12, 22, 11, 90};
       selectionSort(arr);
       System.out.print("Sorted array: ");
       for (int i : arr) {
           System.out.print(i + " ");
       }
       System.out.println();
   }
}

