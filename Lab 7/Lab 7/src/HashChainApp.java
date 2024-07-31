import java.util.LinkedList;
import java.util.List;

public class HashChainApp {
    private List<Integer>[] hashTable;
    private int tableSize;
    private int numElements;
    private int totalProbeLength;

    public HashChainApp(int size) {
        this.tableSize = size;
        this.hashTable = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            hashTable[i] = new LinkedList<>();
        }
        this.numElements = 0;
        this.totalProbeLength = 0;
    }

    private int hash(int key) {
        return key % tableSize;
    }

    public void insert(int key) {
        int hashIndex = hash(key);
        hashTable[hashIndex].add(key);
        numElements++;
        totalProbeLength += hashTable[hashIndex].size();
        System.out.println("Inserted key=" + key + " at index=" + hashIndex + ", chain size=" + hashTable[hashIndex].size());
    }

    public void find(int key) {
        int hashIndex = hash(key);
        List<Integer> chain = hashTable[hashIndex];
        int step = 0;
        for (int k : chain) {
            step++;
            if (k == key) {
                System.out.println("Found key=" + key + " at index=" + hashIndex + " in chain position=" + step);
                return;
            }
        }
        System.out.println("Key " + key + " not found after " + step + " steps in chain at index=" + hashIndex);
    }

    public void displayTable() {
        for (int i = 0; i < tableSize; i++) {
            System.out.print("Index " + i + ": ");
            for (int key : hashTable[i]) {
                System.out.print(key + " ");
            }
            System.out.println();
        }
    }

    public double getAverageProbeLength() {
        return numElements == 0 ? 0 : (double) totalProbeLength / numElements;
    }

    public static void simulateLoadFactors() {
        int[][] testCases = {
            {5, 5},
            {10, 7},
            {20, 18}
        };

        for (int[] testCase : testCases) {
            int tableSize = testCase[0];
            int numKeys = testCase[1];

            System.out.println("\nSimulating load factor with table size: " + tableSize + " and num keys: " + numKeys);
            HashChainApp hashApp = new HashChainApp(tableSize);
            for (int i = 0; i < numKeys; i++) {
                hashApp.insert(i);
            }
            hashApp.displayTable();
            System.out.println("Average probe length: " + hashApp.getAverageProbeLength());
        }
    }

    public static void main(String[] args) {
        int[] keys = {12, 44, 13, 88, 23, 94, 11, 39, 20, 16};
        int tableSize = 11;

        HashChainApp hashApp = new HashChainApp(tableSize);

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

        // Simulate load factors
        simulateLoadFactors();
    }
}
