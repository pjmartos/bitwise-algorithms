import java.util.BitSet;

// Sparse Bitsets: Sparse bitsets are used to represent a large set of integers efficiently, where most of the integers are not present.
//                 Bitwise operations are used to represent and manipulate sparse sets with minimal memory usage.
public class SparseBitset {
    private final BitSet bitSet;
    
    // Constructor to initialize the sparse bitset
    public SparseBitset() {
        bitSet = new BitSet();
    }
    
    // Add an integer to the sparse bitset
    public void add(int num) {
        bitSet.set(num);
    }
    
    // Remove an integer from the sparse bitset
    public void remove(int num) {
        bitSet.clear(num);
    }
    
    // Check if an integer is present in the sparse bitset
    public boolean contains(int num) {
        return bitSet.get(num);
    }
    
    // Get the size of the sparse bitset (number of integers present)
    public int size() {
        return bitSet.cardinality();
    }
    
    // Check if the sparse bitset is empty
    public boolean isEmpty() {
        return bitSet.isEmpty();
    }
    
    // Return a string representation of the sparse bitset
    @Override
    public String toString() {
        return bitSet.toString();
    }

    public static void main(String[] args) {
        // Create a sparse bitset
        SparseBitset sparseSet = new SparseBitset();
        
        // Add some integers to the sparse bitset
        sparseSet.add(5);
        sparseSet.add(10);
        sparseSet.add(20);
        
        // Check if integers are present
        System.out.println("Contains 5: " + sparseSet.contains(5));
        System.out.println("Contains 15: " + sparseSet.contains(15));
        
        // Remove an integer
        sparseSet.remove(10);
        
        // Check the size of the sparse bitset
        System.out.println("Size: " + sparseSet.size());
        
        // Print the sparse bitset
        System.out.println("Sparse Bitset: " + sparseSet.toString());
    }
}
