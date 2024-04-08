import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class SpecialArray {
    private int[] array;
    private Stack<int[]> undoStack;
    private Stack<int[]> redoStack;

    public SpecialArray() {
        array = new int[20];
        generateRandomValues();
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    private void generateRandomValues() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100); // Assuming range of random values from 0 to 99
        }
    }

    public void updateValue(int position, int value) {
        if (position < 0 || position >= array.length) {
            System.out.println("Invalid position.");
            return;
        }

        undoStack.push(array.clone()); // Store a copy of the current array before updating
        array[position] = value;
        redoStack.clear(); // Clear redo stack as redoing after an update invalidates the redo history
    }

    public void undoUpdate() {
        if (!undoStack.isEmpty()) {
            redoStack.push(array.clone()); // Store a copy of the current array before undoing
            array = undoStack.pop(); // Restore the array to the previous state
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public void redoUpdate() {
        if (!redoStack.isEmpty()) {
            undoStack.push(array.clone()); // Store a copy of the current array before redoing
            array = redoStack.pop(); // Restore the array to the next state
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    public void displayArray() {
        System.out.println("Array content:");
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        SpecialArray specialArray = new SpecialArray();
        specialArray.displayArray();

        specialArray.updateValue(5, 50);
        specialArray.displayArray();

        specialArray.undoUpdate();
        specialArray.displayArray();

        specialArray.redoUpdate();
        specialArray.displayArray();
    }
}
