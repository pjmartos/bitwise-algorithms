// Bit Manipulation for Subset Generation: This algorithm generates all possible subsets of a set using bitwise manipulation.
//                                         You iterate through all possible combinations of elements using bitwise operations, including including or excluding each element in a subset.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetGenerator {

    public static void main(String[] args) {
        Set<Integer> inputSet = Set.of(1, 2, 3); // Replace with your own set of elements
        Set<Set<Integer>> subsets = generateSubsets(inputSet);

        // Print all subsets
        for (Set<Integer> subset : subsets) {
            System.out.print("{");
            List<Integer> subsetAsList = new ArrayList<>(subset);
            for (int i = 0; i < subsetAsList.size(); i++) {
                System.out.print(subsetAsList.get(i));
                if (i < subsetAsList.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("}");
        }
    }

    // Function to generate all possible subsets of a set
    public static <T> Set<Set<T>> generateSubsets(Set<T> inputSet) {
        int n = inputSet.size();
        Set<Set<T>> subsets = new HashSet<>();

        // The total number of possible subsets is 2^n
        int totalSubsets = 1 << n;

        List<T> inputAsList = new ArrayList<>(inputSet);
        // Iterate through all possible subset combinations
        for (int i = 0; i < totalSubsets; i++) {
            Set<T> subset = new HashSet<>();

            // Check each bit of 'i' to decide whether to include the corresponding element in the subset
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(inputAsList.get(j));
                }
            }

            subsets.add(subset);
        }
        return subsets;
    }
}