import java.util.Arrays;
class HighArray {
    private long[] a; // Reference to array a
    private int nElements; // Number of data items
    private int comparisons; // Counter for comparisons

    public HighArray(int max) {
        a = new long[max]; // Create the array
        nElements = 0; // No items yet
        comparisons = 0; // Initialize comparisons count
    }

    public boolean find(long searchKey) {
        comparisons = 0; // Reset comparisons for each search
        for (int j = 0; j < nElements; j++) {
            comparisons++; // Increment comparisons count
            if (a[j] == searchKey) {
                return true; // Found it
            }
        }
        return false; // Not found
    }

    public void insert(long value) {
        a[nElements] = value; // Insert it
        nElements++; // Increment size
    }

    public boolean delete(long value) {
        for (int j = 0; j < nElements; j++) {
            if (value == a[j]) {
                for (int k = j; k < nElements - 1; k++) {
                    a[k] = a[k + 1]; // Shift elements left
                }
                nElements--; // Decrement size
                return true; // Deleted
            }
        }
        return false; // Not found
    }

    public long getMax() {
        if (nElements == 0) {
            return -1; // Array is empty
        }
        long max = a[0];
        for (int i = 1; i < nElements; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public long removeMax() {
        if (nElements == 0) {
            return -1; // Array is empty
        }
        long max = getMax();
        delete(max); // Use delete to remove the max value
        return max;
    }

    public void noDups() {
        long[] result = new long[a.length];
        int x = 0;
        for (int i = 0; i < nElements; i++) {
            boolean dup = false;
            for (int j = 0; j < x; j++) {
                if (a[i] == result[j]) {
                    dup = true;
                    break;
                }
            }
            if (!dup) {
                result[x++] = a[i]; // Only add non-duplicates
            }
        }
        a = Arrays.copyOf(result, x); // Resize to remove excess
        nElements = x; // Update the count
    }

    public void show() {
        for (int i = 0; i < nElements; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public int getComparisons() {
        return comparisons; // Return number of comparisons made
    }
}
