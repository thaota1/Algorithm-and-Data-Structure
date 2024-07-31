import java.util.*;

class Node implements Comparable<Node> {
    char ch;
    int frequency;
    Node left, right;

    public Node(char ch, int frequency) {
        this.ch = ch;
        this.frequency = frequency;
    }

    public Node(char ch, int frequency, Node left, Node right) {
        this.ch = ch;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Node other) {
        return this.frequency - other.frequency;
    }
}

public class HuffmanCoding {
    public static Map<Character, String> generateHuffmanCodes(String text) {
        // Calculate character frequencies
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : text.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Build Huffman Tree
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            pq.offer(new Node(entry.getKey(), entry.getValue()));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            pq.offer(new Node('\0', left.frequency + right.frequency, left, right));
        }

        // Generate Huffman Codes
        Node root = pq.poll();
        Map<Character, String> huffmanCodes = new HashMap<>();
        generateCodes(root, "", huffmanCodes);
        return huffmanCodes;
    }

    private static void generateCodes(Node node, String code, Map<Character, String> huffmanCodes) {
        if (node == null) return;
        if (node.ch != '\0') {
            huffmanCodes.put(node.ch, code);
            return;
        }
        generateCodes(node.left, code + "0", huffmanCodes);
        generateCodes(node.right, code + "1", huffmanCodes);
    }

    public static void main(String[] args) {
        String text = "I am a student at International University. My name is TA THI PHUONG THAO. I am working on a DSA lab";

        // Generate Huffman codes
        Map<Character, String> huffmanCodes = generateHuffmanCodes(text);

        // Print Huffman codes
        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

