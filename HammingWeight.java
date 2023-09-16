// Counting Set Bits (Hamming Weight): It counts the number of 1 bits in a binary number.
//                                     You iterate through the bits, checking each one and incrementing a counter for each set bit (each 1).
public class HammingWeight {

    // Function to count the number of set bits (1s) in a binary number
    public static int countSetBits(int num) {
        int count = 0;  // Initialize a counter to 0

        // Iterate through each bit of the binary representation
        while (num > 0) {
            // Use bitwise AND with 1 to check if the least significant bit is set (1)
            if ((num & 1) == 1) {
                count++;  // Increment the counter if the bit is set
            }
            // Right-shift the number by 1 to check the next bit
            num >>= 1;
        }

        return count;  // Return the total count of set bits
    }

    public static void main(String[] args) {
        int number = 357;  // Replace with your binary number

        // Call the function to count set bits
        int result = countSetBits(number);

        // Print the result
        System.out.println("Number of set bits in " + number + " is: " + result);
    }
}
