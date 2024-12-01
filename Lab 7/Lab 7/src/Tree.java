import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Tree {
    private TreeNode root;
    private int comparisonCount;

    public Tree() {
        this.root = null;
        this.comparisonCount = 0;
    }

    // Method to count the nodes in the tree
    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // Method to compute the height of the tree
    public int height() {
        return height(root);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Method to count the number of leaf nodes
    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return countLeaves(node.left) + countLeaves(node.right);
    }

    // Method to check if the tree is balanced
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(TreeNode node) {
        if (node == null) {
            return true;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }

    // Method to add a value to the tree
    public void add(int value) {
        root = addRecursive(root, value);
    }

    private TreeNode addRecursive(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }
        if (value < node.value) {
            node.left = addRecursive(node.left, value);
        } else if (value > node.value) {
            node.right = addRecursive(node.right, value);
        }
        return node;
    }
    // Method to check if two binary trees are identical
    public boolean isIdentical(Tree otherTree) {
    return isIdentical(this.root, otherTree.root);
    }

    private boolean isIdentical(TreeNode node1, TreeNode node2) {
    // If both nodes are null, they are identical
    if (node1 == null && node2 == null) {
        return true;
    }
    // If one of the nodes is null, they are not identical
    if (node1 == null || node2 == null) {
        return false;
    }
    // Check if the current nodes' values are the same and recursively check their subtrees
    return (node1.value == node2.value) &&
           isIdentical(node1.left, node2.left) &&
           isIdentical(node1.right, node2.right);
    }
        // Method to find a value in the tree
    public boolean find(int value) {
        comparisonCount = 0;  // Reset comparison count for each find operation
        return findRecursive(root, value);
    }

    private boolean findRecursive(TreeNode node, int value) {
        if (node == null) {
            comparisonCount++;
            return false;
        }
        comparisonCount++;
        if (value == node.value) {
            return true;
        } else if (value < node.value) {
            return findRecursive(node.left, value);
        } else {
            return findRecursive(node.right, value);
        }
    }

    // Method to insert a value into the tree
    public void insert(int value) {
        comparisonCount = 0;  // Reset comparison count for each insert operation
        root = insertRecursive(root, value);
    }

    private TreeNode insertRecursive(TreeNode node, int value) {
        if (node == null) {
            comparisonCount++;
            return new TreeNode(value);
        }
        comparisonCount++;
        if (value < node.value) {
            node.left = insertRecursive(node.left, value);
        } else if (value > node.value) {
            node.right = insertRecursive(node.right, value);
        }
        return node;
    }

    // Method to delete a value from the tree
    public void delete(int value) {
        comparisonCount = 0;  // Reset comparison count for each delete operation
        root = deleteRecursive(root, value);
    }

    private TreeNode deleteRecursive(TreeNode node, int value) {
        if (node == null) {
            comparisonCount++;
            return null;
        }
        comparisonCount++;
        if (value < node.value) {
            node.left = deleteRecursive(node.left, value);
        } else if (value > node.value) {
            node.right = deleteRecursive(node.right, value);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            node.value = minValue(node.right);
            node.right = deleteRecursive(node.right, node.value);
        }
        return node;
    }

    private int minValue(TreeNode node) {
        int minValue = node.value;
        while (node.left != null) {
            minValue = node.left.value;
            node = node.left;
        }
        return minValue;
    }

    // Method to get the number of comparisons made in find(), insert(), or delete
    public int getComparisonCount() {
        return comparisonCount;
    }

    // Method to clear the tree
    public void clear() {
        root = null;
    }

    // Method to insert random items
    public void insertRandomItems(int count) {
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            insert(rand.nextInt(100));  // Random values between 0 and 99
        }
    }

    // Methods for finding the minimum and maximum value
    public int findMin() {
        return findMinRecursive(root);
    }

    private int findMinRecursive(TreeNode node) {
        if (node == null) {
            throw new IllegalStateException("Tree is empty");
        }
        while (node.left != null) {
            node = node.left;
        }
        return node.value;
    }

    public int findMax() {
        return findMaxRecursive(root);
    }

    private int findMaxRecursive(TreeNode node) {
        if (node == null) {
            throw new IllegalStateException("Tree is empty");
        }
        while (node.right != null) {
            node = node.right;
        }
        return node.value;
    }

    // Method for in-order traversal to save items in an array
    public int[] toArray() {
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    private void inOrderTraversal(TreeNode node, List<Integer> list) {
        if (node != null) {
            inOrderTraversal(node.left, list);
            list.add(node.value);
            inOrderTraversal(node.right, list);
        }
    }
    // Main method for interactive input
    public static void main(String[] args) {
        Tree tree1 = new Tree();
        Tree tree2 = new Tree();
        Scanner scanner = new Scanner(System.in);

        // Populate tree1
        System.out.println("Enter the number of nodes for tree1:");
        int n1 = scanner.nextInt();
        System.out.println("Enter " + n1 + " values for tree1:");
        for (int i = 0; i < n1; i++) {
            int value = scanner.nextInt();
            tree1.add(value);
        }

        // Populate tree2
        System.out.println("Enter the number of nodes for tree2:");
        int n2 = scanner.nextInt();
        System.out.println("Enter " + n2 + " values for tree2:");
        for (int i = 0; i < n2; i++) {
            int value = scanner.nextInt();
            tree2.add(value);
        }

        // Print the properties of the trees
        System.out.println("Tree1 - Number of nodes: " + tree1.countNodes());
        System.out.println("Tree1 - Height of tree: " + tree1.height());
        System.out.println("Tree1 - Number of leaves: " + tree1.countLeaves());
        System.out.println("Tree1 - Is the tree balanced? " + tree1.isBalanced());

        System.out.println("Tree2 - Number of nodes: " + tree2.countNodes());
        System.out.println("Tree2 - Height of tree: " + tree2.height());
        System.out.println("Tree2 - Number of leaves: " + tree2.countLeaves());
        System.out.println("Tree2 - Is the tree balanced? " + tree2.isBalanced());

        // Test if the two trees are identical
        if (tree1.isIdentical(tree2)) {
            System.out.println("The two trees are identical.");
        } else {
            System.out.println("The two trees are not identical.");
        }
    }
}