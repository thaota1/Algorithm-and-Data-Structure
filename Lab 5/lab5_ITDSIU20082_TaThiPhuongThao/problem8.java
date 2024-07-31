import java.util.ArrayList;
import java.util.List;

public class problem8 {
    public static void main(String[] args) {
        List<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);

        List<List<Integer>> subsets = generateSubsets(set);
        
        System.out.println("All subsets:");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }

    public static List<List<Integer>> generateSubsets(List<Integer> set) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsetsHelper(set, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    private static void generateSubsetsHelper(List<Integer> set, int index, List<Integer> currentSubset, List<List<Integer>> subsets) {
        if (index == set.size()) {
            subsets.add(new ArrayList<>(currentSubset));
            return;
        }

        // Include the current element in the subset
        currentSubset.add(set.get(index));
        generateSubsetsHelper(set, index + 1, currentSubset, subsets);

        // Exclude the current element from the subset
        currentSubset.remove(currentSubset.size() - 1);
        generateSubsetsHelper(set, index + 1, currentSubset, subsets);
    }
}


