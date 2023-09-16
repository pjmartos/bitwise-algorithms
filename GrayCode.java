// Gray Code Encoding/Decoding: It converts between binary and Gray code, where two successive values differ in only one bit.
//                              You use bitwise XOR to encode and decode Gray codes, altering one bit at a time.
public class GrayCode {

    // Function to encode binary to Gray code
    public static int binaryToGray(int binary) {
        return binary ^ (binary >> 1);
    }

    // Function to convert Gray code to binary
    public static int grayToBinary(int num) {
        int mask = num >> 1;
        while (mask != 0) {
            num = num ^ mask;
            mask = mask >> 1;
        }
        return num;
    }

    public static void main(String[] args) {
        // Example usage
        int binaryNumber = 7; // Binary: 111
        int grayCode = binaryToGray(binaryNumber);
        int decodedBinary = grayToBinary(grayCode);

        System.out.println("Original Binary: " + binaryNumber);
        System.out.println("Gray Code: " + grayCode);
        System.out.println("Decoded Binary: " + decodedBinary);
    }
}