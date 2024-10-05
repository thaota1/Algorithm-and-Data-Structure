import java.util.Scanner;
public class HighArrayApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create a Scanner object for user input
        int n = 100; // Set the maximum size of the array
        HighArray A; // Declare a HighArray reference
        A = new HighArray(n); // Create a new HighArray object
    
        // Insert predefined elements into the HighArray
        A.insert(50);
        A.insert(90);
        A.insert(77);
        A.insert(44);
        A.insert(58);
        A.insert(15);
        A.insert(11);
        A.insert(77); // Duplicate
        A.insert(77); // Duplicate
        A.insert(19);
    
        // Display the current elements in the array
        A.show();
        System.out.println();
    
        // Read a search key from user input
        System.out.print("Enter a number to search: ");
        int searchKey = sc.nextInt(); 
    
        // Attempt to find the search key in the array
        if(A.find(searchKey)) {
            System.out.println("Found " + searchKey);
        } else {
            System.out.println("Can't find " + searchKey);
        }
    
        // Delete a specific element from the array
        A.delete(50);
        System.out.println("After deletion:");
        A.show();
    
        // Display the maximum value in the array
        System.out.println("Max " + A.getMax());
        
        // Remove and display the maximum value
        System.out.println("Remove Max " + A.removeMax());
        A.show();
        System.out.println();
    
        // Remove duplicate elements from the array
        System.out.println("Remove duplicate elements:");
        A.noDups();
        A.show();
    
        // Close the scanner to prevent resource leaks
        sc.close();
    }
        
}
