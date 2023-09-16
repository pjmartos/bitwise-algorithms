// Bitonic Sorting: It sorts a sequence of numbers in a bitonic order (first increasing, then decreasing).
//                  Bitonic sorting uses a combination of bitwise operations and a specific merging technique to sort the numbers.
public class BitonicSort {

    // Function to perform a bitonic merge
    private static void bitonicMerge(int[] input, int startIndex, int count, boolean ascending) {
        if (count > 1) {
            int sizeOfHalf = count / 2;
            for (int i = startIndex; i < startIndex + sizeOfHalf; i++) {
                // Compare and swap elements based on the desired order (ascending or descending)
                if ((input[i] > input[i + sizeOfHalf]) == ascending) {
                    int temp = input[i];
                    input[i] = input[i + sizeOfHalf];
                    input[i + sizeOfHalf] = temp;
                }
            }
            // Recursively perform bitonic merge on both halves
            bitonicMerge(input, startIndex, sizeOfHalf, ascending);
            bitonicMerge(input, startIndex + sizeOfHalf, sizeOfHalf, ascending);
        }
    }

    // Function to perform a bitonic sort
    private static void bitonicSort(int[] input, int startIndex, int count, boolean ascending) {
        if (count > 1) {
            int sizeOfHalf = count / 2;
            
            // Sort the first half in ascending order
            bitonicSort(input, startIndex, sizeOfHalf, true);
            
            // Sort the second half in descending order
            bitonicSort(input, startIndex + sizeOfHalf, sizeOfHalf, false);
            
            // Merge the two sorted halves
            bitonicMerge(input, startIndex, count, ascending);
        }
    }

    // Public sorting function
    public static void sort(int[] input, boolean ascending) {
        bitonicSort(input, 0, input.length, ascending);
    }

    public static void main(String[] args) {
        int arr[] = {3, 7, 4, 8, 6, 2, 1, 5};
        System.out.print("Original Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        // Call the bitonic sort function
        sort(arr, true); // true for ascending order, false for descending

        System.out.print("\nSorted Array (Bitonic Sort): ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
