public class BubbleSortApp {
   public static void bubbleSort(int[] arr) {
       int n = arr.length;
       int swaps = 0;
       int comparisons = 0;

       for (int i = 0; i < n; i++) {
           for (int j = 0; j < n - i - 1; j++) {
               comparisons++;
               if (arr[j] > arr[j + 1]) {
                   int temp = arr[j];
                   arr[j] = arr[j + 1];
                   arr[j + 1] = temp;
                   swaps++;
               }
           }
           
           // Display array after inner loop
           System.out.print("Array after inner loop " + (i+1) + ": ");
           for (int k : arr) {
               System.out.print(k + " ");
           }
           System.out.println();
           // Display number of swaps after inner loop
           System.out.println("Number of swaps after inner loop " + (i+1) + ": " + swaps);
           // Display number of comparisons after inner loop and total number of comparisons
           System.out.println("Number of comparisons after inner loop " + (i+1) + ": " + comparisons);
       }
   }

   public static void main(String[] args) {
       int[] arr = {64, 34, 25, 12, 22, 11, 90};
       bubbleSort(arr);
       System.out.print("Sorted array: ");
       for (int i : arr) {
           System.out.print(i + " ");
       }
       System.out.println();
   }
}

