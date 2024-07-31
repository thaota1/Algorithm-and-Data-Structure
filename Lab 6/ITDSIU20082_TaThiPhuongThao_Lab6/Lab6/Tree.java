// -------------------------------------------------------------
// Representing arithmetic expressions by binary tree
// CS 501 
// Zdravko Markov
// -------------------------------------------------------------
public class Tree {
   private Node root;

   // Node class definition
   private class Node {
       int value;
       Node left;
       Node right;

       Node(int value) {
           this.value = value;
           left = null;
           right = null;
       }
   }

   // Constructor
   public Tree() {
       root = null;
   }

   // Method to count the elements in the tree
   public int countElements() {
       return countElements(root);
   }

   private int countElements(Node node) {
       if (node == null) {
           return 0;
       }
       return 1 + countElements(node.left) + countElements(node.right);
   }

   // Method to compute the height of the tree
   public int getHeight() {
       return getHeight(root);
   }

   private int getHeight(Node node) {
       if (node == null) {
           return 0;
       }
       int leftHeight = getHeight(node.left);
       int rightHeight = getHeight(node.right);
       return 1 + Math.max(leftHeight, rightHeight);
   }

   // Method to count the leaves in the tree
   public int countLeaves() {
       return countLeaves(root);
   }

   private int countLeaves(Node node) {
       if (node == null) {
           return 0;
       }
       if (node.left == null && node.right == null) {
           return 1;
       }
       return countLeaves(node.left) + countLeaves(node.right);
   }

   // Method to determine if the tree is fully balanced
   public boolean isFullyBalanced() {
       return isFullyBalanced(root);
   }

   private boolean isFullyBalanced(Node node) {
       if (node == null) {
           return true;
       }
       int leftHeight = getHeight(node.left);
       int rightHeight = getHeight(node.right);
       return Math.abs(leftHeight - rightHeight) <= 1 && isFullyBalanced(node.left) && isFullyBalanced(node.right);
   }

   // Method to determine if two trees are identical
   public boolean isIdentical(Tree otherTree) {
       return isIdentical(this.root, otherTree.root);
   }

   private boolean isIdentical(Node node1, Node node2) {
       if (node1 == null && node2 == null) {
           return true;
       }
       if (node1 == null || node2 == null) {
           return false;
       }
       return (node1.value == node2.value) && 
              isIdentical(node1.left, node2.left) && 
              isIdentical(node1.right, node2.right);
   }

   // Method to add elements to the tree for testing purposes
   public void add(int value) {
       root = addRecursive(root, value);
   }

   private Node addRecursive(Node node, int value) {
       if (node == null) {
           return new Node(value);
       }

       if (value < node.value) {
           node.left = addRecursive(node.left, value);
       } else if (value > node.value) {
           node.right = addRecursive(node.right, value);
       }

       return node;
   }

   // Main method for testing
   public static void main(String[] args) {
       Tree tree1 = new Tree();
       tree1.add(5);
       tree1.add(3);
       tree1.add(7);

       Tree tree2 = new Tree();
       tree2.add(5);
       tree2.add(3);
       tree2.add(7);

       Tree tree3 = new Tree();
       tree3.add(5);
       tree3.add(4);
       tree3.add(7);

       System.out.println("Number of elements in tree1: " + tree1.countElements());
       System.out.println("Height of tree1: " + tree1.getHeight());
       System.out.println("Number of leaves in tree1: " + tree1.countLeaves());
       System.out.println("Is tree1 fully balanced? " + tree1.isFullyBalanced());
       System.out.println("Tree1 is identical to Tree2: " + tree1.isIdentical(tree2)); // Should print true
       System.out.println("Tree1 is identical to Tree3: " + tree1.isIdentical(tree3)); // Should print false
   }
}



