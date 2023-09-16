import java.util.ArrayList;
import java.util.List;

// Counting Inversions in an Array: This algorithm counts the number of inversions (pair of elements out of order) in an array.
//                                  Bitwise operations can be used to efficiently count inversions during the merge step of a divide-and-conquer sorting algorithm.
public class CountInversions {

    public static long invCount(int[] input) {
        return invCount(input, 1 << 16);
    }

    private static long invCount(int[] input, int mask) {
        if (mask == 0 || input.length == 0) {
            return 0;
        }

        long count = 0;
        List<Integer> greater = new ArrayList<>();
        List<Integer> smaller = new ArrayList<>();

        for (int currentNumber : input) {
			// If the number has the bit pointed by the mask set to one, we store in "greater" the result from subtracting the mask from the number
            if ((currentNumber & mask) != 0) {
                greater.add(currentNumber & ~mask);
            } else {
				// The number is smaller than the mask
				// Every number stored in the "greater" list is greater than it, so each of those numbers is wrongly sorted (they are inversions)
                count += greater.size();
                smaller.add(currentNumber);
            }
        }

        mask >>= 1; // Divide m by 2 using bitwise right shift to make the mask smaller each time

        // The count of inversions is the current count, plus the inversions computed recursively from each sublist ("greater" and "smaller")
        return count
               + invCount(toArray(greater), mask)
               + invCount(toArray(smaller), mask);
    }

    private static int[] toArray(List<Integer> list) {
        return list.stream()
               .mapToInt(Integer::intValue)
               .toArray();
    }

    public static void main(String[] args) {
        int[] input = {8, 4, 2, 1};
        long inversions = invCount(input);
        System.out.println("Number of inversions: " + inversions); // Output: 6
    }
}