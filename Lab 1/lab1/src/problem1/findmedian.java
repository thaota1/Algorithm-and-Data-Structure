import java.util.*;

public class findmedian {

    public static double findMedian(List<Integer> numbers) {
        Collections.sort(numbers); // Sort numbers

        int size = numbers.size();
        
        if (size % 2 == 0) {
            // If the size of the list is even, median is the average of the middle two numbers
            int midIndex1 = size / 2 - 1;
            int midIndex2 = size / 2;
            return (numbers.get(midIndex1) + numbers.get(midIndex2)) / 2.0;
        } else {
            // If the size of the list is odd, median is the middle number
            int midIndex = size / 2;
            return numbers.get(midIndex);
        }
    }

    public static void main(String[] args) {
        // Example usage:
        List<Integer> numbers = new ArrayList<>(Arrays.asList(7, 2, 1, 5, 9, 3, 6, 4, 8));
        double median = findMedian(numbers);
        System.out.println("Median: " + median);
    }
}
