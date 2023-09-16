// Fast Exponentiation (Exponentiation by Squaring): This algorithm computes large exponentiations efficiently.
//                                                   Bitwise operations help optimize the process by breaking down the exponentiation into smaller steps.
public class FastExponentiation {

    // This function calculates base^exponent using the Fast Exponentiation algorithm.
    public static long fastExponentiation(long base, long exponent) {
        // Base case: If the exponent is 0, return 1.
        if (exponent == 0) {
            return 1;
        }
        
        // If the exponent is even, reduce the problem by half and square the result.
        if (exponent % 2 == 0) {
            long halfResult = fastExponentiation(base, exponent / 2);
            return halfResult * halfResult;
        }
        // If the exponent is odd, reduce the problem by half and square the result,
        // then multiply by the base.
        else {
            long halfResult = fastExponentiation(base, (exponent - 1) / 2);
            return base * halfResult * halfResult;
        }
    }

    public static void main(String[] args) {
        long base = 2;      // Base number
        long exponent = 10; // Exponent

        // Calculate base^exponent using fast exponentiation
        long result = fastExponentiation(base, exponent);

        // Display the result
        System.out.println(base + "^" + exponent + " = " + result);
    }
}
