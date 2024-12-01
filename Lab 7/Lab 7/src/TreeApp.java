import java.util.Scanner;

public class TreeApp {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("Choose an option:");
            System.out.println("1. Insert random items");
            System.out.println("2. Find an item");
            System.out.println("3. Insert an item");
            System.out.println("4. Delete an item");
            System.out.println("5. Count comparisons");
            System.out.println("6. Find minimum item");
            System.out.println("7. Find maximum item");
            System.out.println("8. Clear the tree");
            System.out.println("9. Traverse the tree (in-order)");
            System.out.println("10. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the number of random items to insert:");
                    int count = scanner.nextInt();
                    tree.insertRandomItems(count);
                    break;

                case 2:
                    System.out.println("Enter the value to find:");
                    int findValue = scanner.nextInt();
                    if (tree.find(findValue)) {
                        System.out.println("Value found!");
                    } else {
                        System.out.println("Value not found!");
                    }
                    System.out.println("Comparisons: " + tree.getComparisonCount());
                    break;

                case 3:
                    System.out.println("Enter the value to insert:");
                    int insertValue = scanner.nextInt();
                    tree.insert(insertValue);
                    System.out.println("Comparisons: " + tree.getComparisonCount());
                    break;

                case 4:
                    System.out.println("Enter the value to delete:");
                    int deleteValue = scanner.nextInt();
                    tree.delete(deleteValue);
                    System.out.println("Comparisons: " + tree.getComparisonCount());
                    break;

                case 5:
                    System.out.println("Total comparisons: " + tree.getComparisonCount());
                    break;

                case 6:
                    System.out.println("Minimum value: " + tree.findMin());
                    break;

                case 7:
                    System.out.println("Maximum value: " + tree.findMax());
                    break;

                case 8:
                    tree.clear();
                    System.out.println("Tree cleared.");
                    break;

                case 9:
                    int[] array = tree.toArray();
                    System.out.println("In-order traversal:");
                    for (int value : array) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                    break;

                case 10:
                    exit = true;
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
