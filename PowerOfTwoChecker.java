// Checking for Power of Two: This algorithm checks if a number is a power of tw
//                            You use bitwise AND to check if only one bit is set in the binary representation. If so, it's a power of two.
public class PowerOfTwoChecker {

    public static void main(String[] args) {
        int number = 16; // Change this number to check different values
        boolean result = isPowerOfTwo(number);
        
        if (result) {
            System.out.println(number + " is a power of two.");
        } else {
            System.out.println(number + " is not a power of two.");
        }
    }

    public static boolean isPowerOfTwo(int num) {
        if (num <= 0) {
            return false; // Negative numbers and zero are not powers of two.
        }
        
        // Use bitwise AND to check if only one bit is set in the binary representation.
        // A power of two in binary form is like 100...00 (1 followed by all zeros).
        // So, if we subtract 1 from a power of two, we get a binary representation like 011...11.
        // If we perform a bitwise AND between the number and (number - 1), it should result in 0 for powers of two.
        // For example: 16 (10000) & 15 (01111) = 0
        return (num & (num - 1)) == 0;
    }
}
