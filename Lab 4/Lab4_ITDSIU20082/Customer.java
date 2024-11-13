// Customer.java
import java.util.Random;

public class Customer {
    private int customerId;
    private int serviceTime;  // Random time to be served

    // Constructor
    public Customer(int id) {
        this.customerId = id;
        this.serviceTime = new Random().nextInt(10) + 1;  // Random time between 1 and 10
    }

    public int getId() {
        return customerId;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void serve() {
        try {
            System.out.println("Serving customer " + customerId + " for " + serviceTime + " seconds.");
            Thread.sleep(serviceTime * 1000);  // Simulate serving time in seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
