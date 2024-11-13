import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class LinkStackApp {

    // Method to reverse a list using a stack
    public static List<Integer> reverseList(List<Integer> inputList) {
        Stack<Integer> stack = new Stack<>();
        
        // Push all elements of the list into the stack
        for (Integer element : inputList) {
            stack.push(element);
        }

        // Pop elements from the stack and store them in the reversed list
        List<Integer> reversedList = new ArrayList<>();
        while (!stack.isEmpty()) {
            reversedList.add(stack.pop());
        }

        return reversedList;
    }

    public static void main(String[] args) {
        // Example list to reverse
        List<Integer> originalList = new ArrayList<>();
        originalList.add(3);
        originalList.add(24);
        originalList.add(14);
        originalList.add(44);
        originalList.add(53);
        
        System.out.println("Original List: " + originalList);

        // Reverse the list using the stack
        List<Integer> reversedList = reverseList(originalList);
        
        System.out.println("Reversed List: " + reversedList);
    }
}
