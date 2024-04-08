import java.util.Stack;

public class SimpleStack {
    public static void main(String[] args) {
        int decimalNum = 469;
        String octalNum = decimalToOctal(decimalNum);
        System.out.println("Decimal: " + decimalNum);
        System.out.println("Octal: " + octalNum);

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        stack2.push(1);
        stack2.push(2);
        stack2.push(3);

        Stack<Integer> concatenatedStack = concatenateStacks(stack1, stack2);
        System.out.println("Concatenated Stack: " + concatenatedStack);

        System.out.println("Are stacks identical? " + areStacksIdentical(stack1, stack2));
    }

    public static String decimalToOctal(int decimalNum) {
        Stack<Integer> octalStack = new Stack<>();
        while (decimalNum > 0) {
            int remainder = decimalNum % 8;
            octalStack.push(remainder);
            decimalNum /= 8;
        }

        StringBuilder octalNum = new StringBuilder();
        while (!octalStack.isEmpty()) {
            octalNum.append(octalStack.pop());
        }

        return octalNum.toString();
    }

    public static Stack<Integer> concatenateStacks(Stack<Integer> stack1, Stack<Integer> stack2) {
        Stack<Integer> concatenatedStack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();

        while (!stack2.isEmpty()) {
            tempStack.push(stack2.pop());
        }

        while (!tempStack.isEmpty()) {
            stack1.push(tempStack.pop());
        }

        while (!stack1.isEmpty()) {
            concatenatedStack.push(stack1.pop());
        }

        return concatenatedStack;
    }

    public static boolean areStacksIdentical(Stack<Integer> stack1, Stack<Integer> stack2) {
        if (stack1.size() != stack2.size()) {
            return false;
        }

        while (!stack1.isEmpty()) {
            if (!stack1.pop().equals(stack2.pop())) {
                return false;
            }
        }

        return true;
    }
}
