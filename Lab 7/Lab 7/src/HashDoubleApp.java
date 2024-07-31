import java.util.Arrays;

public class HashDoubleApp {
    private Integer[] hashTable;
    private int tableSize;
    private int numElements;
    private int totalProbeLength;

    public HashDoubleApp(int size) {
        this.tableSize = size;
        this.hashTable = new Integer[size];
        this.numElements = 0;
        this.totalProbeLength = 0;
    }

    private int hash1(int key) {
        return key % tableSize;
    }

    private int hash2(int key) {
        return 1 + (key % (tableSize - 1));
    }

    public void insert(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        int step = 0;
        int originalHash1 = hash1;

        while (hashTable[hash1] != null) {
            System.out.println("Insert probing: key=" + key + ", step=" + step + ", hash1=" + hash1 + ", hash2=" + hash2);
            hash1 = (hash1 + hash2) % tableSize;
            step++;
        }

        hashTable[hash1] = key;
        numElements++;
        totalProbeLength += step;
        System.out.println("Inserted key=" + key + " at index=" + hash1 + ", total steps=" + step);
    }

    public void find(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        int step = 0;
        int originalHash1 = hash1;

        while (hashTable[hash1] != null && !hashTable[hash1].equals(key)) {
            System.out.println("Find probing: key=" + key + ", step=" + step + ", hash1=" + hash1 + ", hash2=" + hash2);
            hash1 = (hash1 + hash2) % tableSize;
            step++;
            if (step > tableSize) {
                System.out.println("Key " + key + " not found after " + step + " steps");
                return;
            }
        }

        if (hashTable[hash1] == null) {
            System.out.println("Key " + key + " not found after " + step + " steps");
        } else {
            System.out.println("Found key=" + key + " at index=" + hash1 + ", total steps=" + step);
        }
    }

    public void displayTable() {
        System.out.println(Arrays.toString(hashTable));
    }

    public double getAverageProbeLength() {
        return numElements == 0 ? 0 : (double) totalProbeLength / numElements;
    }

    public static void main(String[] args) {
        int[] keys = {12, 44, 13, 88, 23, 94, 11, 39, 20, 16};
        int tableSize = 11;

        HashDoubleApp hashApp = new HashDoubleApp(tableSize);

        // Insert keys and display table
        for (int key : keys) {
            hashApp.insert(key);
        }
        hashApp.displayTable();

        // Find keys
        hashApp.find(23);
        hashApp.find(50);  // This key is not in the table

        // Display average probe length
        System.out.println("Average probe length for initial filling: " + hashApp.getAverageProbeLength());
    }
}
