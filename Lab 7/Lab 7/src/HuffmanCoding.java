import java.util.*;

class HuffmanNode {
    char character;
    int frequency;
    HuffmanNode left, right;

    public HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        left = right = null;
    }
}

class HuffmanTree {
    private HuffmanNode root;

    // Build the Huffman Tree and generate codes
    public void buildHuffmanTree(String text) {
        // Step 1: Calculate the frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Create a priority queue (min-heap) for building the tree
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.frequency));

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            priorityQueue.offer(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        // Step 3: Build the Huffman Tree
        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();

            HuffmanNode newNode = new HuffmanNode('\0', left.frequency + right.frequency);
            newNode.left = left;
            newNode.right = right;

            priorityQueue.offer(newNode);
        }

        root = priorityQueue.poll(); // The root of the Huffman tree
    }

    // Generate Huffman codes from the tree
    public Map<Character, String> generateCodes() {
        Map<Character, String> codes = new HashMap<>();
        generateCodesRecursive(root, "", codes);
        return codes;
    }

    private void generateCodesRecursive(HuffmanNode node, String code, Map<Character, String> codes) {
        if (node == null) return;

        if (node.character != '\0') {
            codes.put(node.character, code);
        }

        generateCodesRecursive(node.left, code + "0", codes);
        generateCodesRecursive(node.right, code + "1", codes);
    }

    // Method to visualize the Huffman tree (in-order traversal)
    public void printTree() {
        printTreeRecursive(root, "", true);
    }

    private void printTreeRecursive(HuffmanNode node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "L---- " : "R---- ") + (node.character != '\0' ? node.character : node.frequency));
            printTreeRecursive(node.left, prefix + (isLeft ? "|     " : "      "), true);
            printTreeRecursive(node.right, prefix + (isLeft ? "|     " : "      "), false);
        }
    }
}

public class HuffmanCoding {
    public static void main(String[] args) {
        String text = "I am a student at International University. My name is Ta Thi Phuong Thao. I am working on a DSA lab";

        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.buildHuffmanTree(text);

        // Print Huffman codes
        System.out.println("Huffman Codes for each character:");
        Map<Character, String> codes = huffmanTree.generateCodes();
        for (Map.Entry<Character, String> entry : codes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Print the Huffman tree visualization
        System.out.println("\nHuffman Tree Visualization:");
        huffmanTree.printTree();
    }
}
