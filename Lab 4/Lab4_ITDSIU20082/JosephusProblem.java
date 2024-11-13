import java.util.*;

class CircularLinkedList {
    Node head, tail;

    class Node {
        int personNumber;
        Node next;

        public Node(int personNumber) {
            this.personNumber = personNumber;
            this.next = null;
        }
    }

    // Add a person to the circular linked list
    public void addPerson(int personNumber) {
        Node newNode = new Node(personNumber);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head; // Make it circular
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Circular link back to head
        }
    }

    // Recursive function to eliminate the k-th person
    public void Josh(int k, Node current, int index, List<Integer> eliminationOrder) {
        if (current == current.next) {  // Base case: only one person left
            eliminationOrder.add(current.personNumber);
            return;
        }

        // Find the next person to be eliminated
        for (int i = 1; i < k; i++) {
            current = current.next;
        }

        // Eliminate the k-th person
        eliminationOrder.add(current.next.personNumber);
        current.next = current.next.next; // Skip over the eliminated person

        // Recursive call for the next round
        Josh(k, current.next, index, eliminationOrder);
    }

    // Helper method to start the elimination process
    public void startElimination(int k, int startPerson) {
        List<Integer> eliminationOrder = new ArrayList<>();

        // Find the starting person
        Node current = head;
        while (current.personNumber != startPerson) {
            current = current.next;
        }

        // Start the recursive elimination process
        Josh(k, current, 0, eliminationOrder);

        // Print the elimination order
        System.out.println("Elimination order: " + eliminationOrder);
        System.out.println("Last person standing: " + eliminationOrder.get(eliminationOrder.size() - 1));
    }
}

public class JosephusProblem {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        // Input for the number of people, step size, and start person
        System.out.print("Enter the number of people in the circle: ");
        int n = scanner.nextInt();

        System.out.print("Enter the number used for counting off: ");
        int k = scanner.nextInt();

        System.out.print("Enter the number of the person where counting starts: ");
        int startPerson = scanner.nextInt();

        // Create the circular linked list and add people
        CircularLinkedList circle = new CircularLinkedList();
        for (int i = 1; i <= n; i++) {
            circle.addPerson(i);
        }

        // Adjust k to eliminate the k-th person (not the (k-1)th)
        k--;  // Since the given k is a human-readable number (1-indexed)

        // Start the elimination process
        circle.startElimination(k, startPerson);
    }
}
