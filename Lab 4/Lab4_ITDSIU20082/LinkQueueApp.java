// LinkQueueApp.java
import java.util.Random;

public class LinkQueueApp {

    public static void main(String[] args) {
        Queue customerQueue = new Queue();
        Random random = new Random();

        // Simulate customers joining the queue
        for (int i = 1; i <= 10; i++) {
            customerQueue.add(i);
            System.out.println("Customer " + i + " joined the queue.");
        }

        // Simulate serving customers with random times
        while (!customerQueue.isEmpty()) {
            int customerId = customerQueue.remove(random.nextInt(customerQueue.size()) + 1);
            if (customerId != -1) {
                Customer customer = new Customer(customerId);
                customer.serve();
            }
        }

        // Investigating how simulation is affected by queue size
        System.out.println("Final queue size: " + customerQueue.size());
    }
}
