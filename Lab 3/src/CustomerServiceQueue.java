import java.util.LinkedList;
import java.util.Queue;

public class CustomerServiceQueue {
    
    // Two separate queues for VIP and regular customers
    private Queue<String> vipQueue;
    private Queue<String> regularQueue;

    // Constructor to initialize the queues
    public CustomerServiceQueue() {
        vipQueue = new LinkedList<>();
        regularQueue = new LinkedList<>();
    }

    // Enqueue method to add a customer to the correct queue
    public void enqueue(String customerName, boolean isVip) {
        if (isVip) {
            vipQueue.offer(customerName);  // Add to VIP queue
        } else {
            regularQueue.offer(customerName);  // Add to regular queue
        }
    }

    // Serve the next customer (VIPs first, then regular customers)
    public String serveCustomer() {
        if (!vipQueue.isEmpty()) {
            return "Serve " + vipQueue.poll();  // Serve the first VIP customer
        } else if (!regularQueue.isEmpty()) {
            return "Serve " + regularQueue.poll();  // Serve the first regular customer
        } else {
            return "No customers to serve";
        }
    }

    public static void main(String[] args) {
        CustomerServiceQueue serviceQueue = new CustomerServiceQueue();

        serviceQueue.enqueue("Alice", false);
        serviceQueue.enqueue("Bob", true);
        serviceQueue.enqueue("Charlie", false);
        
        System.out.println(serviceQueue.serveCustomer());  // Should serve Bob (VIP)
        System.out.println(serviceQueue.serveCustomer());  // Should serve Alice (Regular)
        System.out.println(serviceQueue.serveCustomer());  // Should serve Charlie (Regular)
    }
}
