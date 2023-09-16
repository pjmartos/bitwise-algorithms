import java.util.BitSet;
import java.util.function.Function;

// Bloom Filter: A Bloom filter is a probabilistic data structure used to test whether an element is a member of a set.
//               It relies on multiple hash functions and bitwise operations to set and check bits in a bit array.
public class BloomFilter<T> {
    private final BitSet bitSet;
    private final Function<T, Integer>[] hashFunctions;

    /**
     * Initializes a Bloom Filter with the given parameters.
     *
     * @param expectedSize      The expected number of elements to be inserted.
     * @param falsePositiveRate The desired false positive rate (e.g., 0.01 for 1% false positives).
     */
    public BloomFilter(int expectedSize, double falsePositiveRate) {
        // Calculate the size of the bit array based on the expected size and false positive rate.
        int size = calculateSize(expectedSize, falsePositiveRate);
        bitSet = new BitSet(size);

        // Calculate the number of hash functions based on the size and expected size.
        int numHashFunctions = calculateNumHashFunctions(size, expectedSize);

        // Initialize the hash functions.
        hashFunctions = new Function[numHashFunctions];
        for (int i = 0; i < numHashFunctions; i++) {
            int seed = i; // Seed for the hash function
            hashFunctions[i] = element -> {
                int hash = element.hashCode();
                // Apply a different hash function using the seed.
                return (hash ^ seed) % size;
            };
        }
    }

    /**
     * Adds an element to the Bloom Filter.
     *
     * @param element The element to be added.
     */
    public void add(T element) {
        for (Function<T, Integer> hashFunction : hashFunctions) {
            int index = hashFunction.apply(element);
            bitSet.set(index, true);
        }
    }

    /**
     * Checks if an element may be in the set (may produce false positives).
     *
     * @param element The element to be checked.
     * @return True if the element may be in the set, false if it is definitely not.
     */
    public boolean mightContain(T element) {
        for (Function<T, Integer> hashFunction : hashFunctions) {
            int index = hashFunction.apply(element);
            if (!bitSet.get(index)) {
                return false; // If any bit is not set, the element is definitely not in the set.
            }
        }
        return true; // All bits are set, so the element may be in the set (may produce false positives).
    }

    /**
     * Calculates the optimal size of the bit array based on the expected size and false positive rate.
     */
    private int calculateSize(int expectedSize, double falsePositiveRate) {
		return Math.ceil((-expectedSize * Math.log(falsePositiveRate)) / Math.log(2));
    }

    /**
     * Calculates the optimal number of hash functions based on the size and expected size.
     */
    private int calculateNumHashFunctions(int size, int expectedSize) {
        return Math.max(1, (int) Math.round(((double) size / expectedSize) * Math.log(2)));
    }
}
