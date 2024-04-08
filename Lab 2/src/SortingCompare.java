import java.util.Random;

public class SortingCompare {
    public static void main(String[] args) {
        int[] arraySizes = {10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000};

        System.out.println("Array Size\tBubble Sort\tSelection Sort\tInsertion Sort");

        for (int size : arraySizes) {
            int[] arr = generateRandomArray(size);
            int[] arrCopy1 = arr.clone();
            int[] arrCopy2 = arr.clone();
            int[] arrCopy3 = arr.clone();

            System.out.print(size + "\t\t");

            // Bubble Sort
            long startTime = System.nanoTime();
            bubbleSort(arrCopy1);
            long endTime = System.nanoTime();
            long bubbleTime = endTime - startTime;
            System.out.print(bubbleTime + " ns\t");

            // Selection Sort
            startTime = System.nanoTime();
            selectionSort(arrCopy2);
            endTime = System.nanoTime();
            long selectionTime = endTime - startTime;
            System.out.print(selectionTime + " ns\t\t");

            // Insertion Sort
            startTime = System.nanoTime();
            insertionSort(arrCopy3);
            endTime = System.nanoTime();
            long insertionTime = endTime - startTime;
            System.out.print(insertionTime + " ns");

            System.out.println();
        }
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt();
        }
        return arr;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int comparisons = 0;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                }
            }
        }
    }

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

            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                swaps++;
            }
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        int comparisons = 0;
        int copies = 0;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
                comparisons++;
                copies++;
            }
            arr[j + 1] = key;
            copies++;
        }
    }
}

