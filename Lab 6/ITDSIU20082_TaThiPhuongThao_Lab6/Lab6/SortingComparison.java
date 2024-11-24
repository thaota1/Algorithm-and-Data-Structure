import java.util.Random;

public class SortingComparison {

    static int mergeComparisons = 0, mergeCopies = 0;
    static int shellComparisons = 0, shellSwaps = 0;
    static int quickComparisons = 0, quickSwaps = 0;

    // Merge Sort
    public static void mergeSort(int[] array, int[] temp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, temp, left, mid);
            mergeSort(array, temp, mid + 1, right);
            merge(array, temp, left, mid, right);
        }
    }

    public static void merge(int[] array, int[] temp, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            mergeComparisons++;
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
            mergeCopies++;
        }
        while (i <= mid) {
            temp[k++] = array[i++];
            mergeCopies++;
        }
        while (j <= right) {
            temp[k++] = array[j++];
            mergeCopies++;
        }
        for (i = left; i <= right; i++) {
            array[i] = temp[i];
        }
    }

    // Shell Sort
    public static void shellSort(int[] array) {
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j = i;
                while (j >= gap && array[j - gap] > temp) {
                    shellComparisons++;
                    array[j] = array[j - gap];
                    shellSwaps++;
                    j -= gap;
                }
                array[j] = temp;
            }
        }
    }

    // Quick Sort
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            quickComparisons++;
            if (array[j] < pivot) {
                i++;
                quickSwaps++;
                swap(array, i, j);
            }
        }
        quickSwaps++;
        swap(array, i + 1, high);
        return i + 1;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] sizes = {10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000};
        Random random = new Random();

        System.out.println("Compare with the same table in Lab 2 with simple sorting algorithms.");
        System.out.println("COPIES/ COMPARISONS/ SWAPS");
        System.out.printf("%-15s %-30s %-30s %-30s\n", "SIZE", "Merge Sort", "Shell Sort", "Quick Sort");
        System.out.printf("%-15s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", "",
                "COPIES", "COMPS", "SWAPS", "COPIES", "COMPS", "SWAPS", "COMPS", "SWAPS");

        for (int size : sizes) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = random.nextInt(size);
            }

            // Merge Sort
            int[] mergeArray = array.clone();
            int[] temp = new int[size];
            mergeComparisons = 0;
            mergeCopies = 0;
            mergeSort(mergeArray, temp, 0, size - 1);

            // Shell Sort
            int[] shellArray = array.clone();
            shellComparisons = 0;
            shellSwaps = 0;
            shellSort(shellArray);

            // Quick Sort
            int[] quickArray = array.clone();
            quickComparisons = 0;
            quickSwaps = 0;
            quickSort(quickArray, 0, size - 1);

            // Print Results
            System.out.printf("%-15d %-10d %-10d %-10s %-10s %-10d %-10d %-10d %-10d\n",
                    size, mergeCopies, mergeComparisons, "-",
                    "-", shellComparisons, shellSwaps,
                    quickComparisons, quickSwaps);
        }
    }
}
