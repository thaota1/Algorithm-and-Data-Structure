// Queue.java
import java.util.LinkedList;
public class Queue {
    private LinkedList<Integer> queue;

    // Constructor
    public Queue() {
        this.queue = new LinkedList<>();
    }

    // Adds a customer to the queue
    public void add(int customerId) {
        queue.add(customerId);
    }

    // Removes the Nth customer after N calls to remove()
    public int remove(int n) {
        if (n <= 0 || n > queue.size()) {
            System.out.println("Invalid position.");
            return -1;
        }

        for (int i = 1; i < n; i++) {
            queue.add(queue.remove());  // Move customers to the end
        }

        return queue.remove();  // Remove the Nth customer
    }

    // Returns the size of the queue
    public int size() {
        return queue.size();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
