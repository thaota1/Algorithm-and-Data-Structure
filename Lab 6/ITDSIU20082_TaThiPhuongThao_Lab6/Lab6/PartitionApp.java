import java.util.Random;

public class PartitionApp {
    private static int comparisons; // Counter for comparisons
    private static int swaps;       // Counter for swaps

    public static void main(String[] args) {
        int[] array = generateRandomArray(100); // Generate a random array
        int size = array.length;

        // Run with different pivot strategies and compute averages
        System.out.println("Pivot Strategy: First Element");
        runExperiment(array, size, "first");

        System.out.println("\nPivot Strategy: Last Element");
        runExperiment(array, size, "last");

        System.out.println("\nPivot Strategy: Middle Element");
        runExperiment(array, size, "middle");

        System.out.println("\nPivot Strategy: Random Element");
        runExperiment(array, size, "random");
    }

    // Function to perform experiments for a given pivot strategy
    private static void runExperiment(int[] array, int size, String pivotStrategy) {
        int totalComparisons = 0;
        int totalSwaps = 0;

        for (int i = 0; i < 100; i++) {
            int[] tempArray = array.clone();
            comparisons = 0;
            swaps = 0;

            partition(tempArray, 0, size - 1, pivotStrategy);

            totalComparisons += comparisons;
            totalSwaps += swaps;
        }

        System.out.println("Average Comparisons: " + totalComparisons / 100);
        System.out.println("Average Swaps: " + totalSwaps / 100);
    }

    // Partition function with pivot strategies
    private static int partition(int[] array, int low, int high, String pivotStrategy) {
        int pivotIndex = selectPivot(array, low, high, pivotStrategy);
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, high); // Move pivot to the end
        int i = low - 1;

        for (int j = low; j < high; j++) {
            comparisons++;
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    // Function to select the pivot based on strategy
    private static int selectPivot(int[] array, int low, int high, String strategy) {
        switch (strategy) {
            case "first":
                return low;
            case "last":
                return high;
            case "middle":
                return low + (high - low) / 2;
            case "random":
                Random random = new Random();
                return low + random.nextInt(high - low + 1);
            default:
                return high; // Default to the last element
        }
    }

    // Swap two elements in the array
    private static void swap(int[] array, int i, int j) {
        swaps++;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Generate a random array of integers
    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000); // Random numbers between 0 and 999
        }
        return array;
    }
}