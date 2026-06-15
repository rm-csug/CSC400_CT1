import java.util.ArrayList;

/**
 * A generic Bag data structure that allows duplicate entries with any
 * particular order.
 * 
 * @param <T> type of elements stored in bag
 */
public class Bag<T> {

    // Internal list that holds bag entries.
    private ArrayList<T> items;

    // Constructs an empty Bag.
    public Bag() {
        items = new ArrayList<>();
    }

    // Mutating operations (bag contents changed)
    /**
     * Adds one occurrence of specified item to the bag.
     * 
     * @param item item to add
     */
    public void add(T item) {
        items.add(item);
    }

    /**
     * Removes one occurrence of specified item from the bag.
     * 
     * @param item item to remove
     */
    public void remove(T item) {
        // removes the first matching element and returns true (if collection changed).
        items.remove(item);
    }

    /**
     * Removes all items from the bag, leaving it empty.
     */
    public void clear() {
        items.clear();
    }

    // Non-mutating query operations (bag contents not changed)
    /**
     * Checks whether the bag currently holds no items.
     * 
     * @return true if the bag is empty; false otherwise
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * Checks if bag contains at least one occurrence of specified item.
     * 
     * @param item item to search for
     * @return true if item exists in bag; false if not
     */
    public boolean contains(T item) {
        return items.contains(item);
    }

    /**
     * Returns number of times the specified item appears in the bag.
     * 
     * @param item item to be counted
     * @return count of occurrences (>= 0)
     */
    public int count(T item) {
        int frequency = 0;
        for (T entry : items) {
            // Null-safe equality check.
            if (entry != null && entry.equals(item)) {
                frequency++;
            } else if (entry == null && item == null) {
                frequency++;
            }
        }
        return frequency;
    }

    /**
     * Returns string representation of the bag contents.
     * Order reflects insertion order.
     * 
     * @return string listing current bag elements
     */
    @Override
    public String toString() {
        return "Bag" + items.toString();
    }

    // demonstrates Bag operations
    public static void main(String[] args) {
        // Create an instance of the Bag class.
        System.out.println("1. Creating a new Bag<String> (Gunpla Collection)");
        Bag<String> gunplaBag = new Bag<>();

        // After creating the empty bag (step 1)
        System.out.println("Is the bag empty? " + gunplaBag.isEmpty()); // true

        // Add several elements to the bag, including duplicates.
        System.out.println("\n2. Adding kits to collection");
        gunplaBag.add("HG RX-78-2 Gundam");
        gunplaBag.add("MG Zaku II");
        gunplaBag.add("HG RX-78-2 Gundam"); // second copy, one built/one boxed
        gunplaBag.add("PG Unicorn Gundam");
        gunplaBag.add("MG Zaku II"); // two Zakus for a diorama
        gunplaBag.add("HG RX-78-2 Gundam"); // third copy

        // Print bag contents
        System.out.println("-Bag contents-");
        System.out.println(gunplaBag);

        // Test contains() method for a few elements
        System.out.println("\n-Testing contains()-");
        System.out.println("Contains 'HG RX-78-2 Gundam'? " + gunplaBag.contains("HG RX-78-2 Gundam")); // true
        System.out.println("Contains 'PG Unicorn Gundam'? " + gunplaBag.contains("PG Unicorn Gundam")); // true
        System.out.println("Contains 'MG Wing Gundam'?    " + gunplaBag.contains("MG Wing Gundam")); // false

        // Test count() method for a few elements
        System.out.println("\n-Testing count()-");
        System.out.println("Count of 'HG RX-78-2 Gundam': " + gunplaBag.count("HG RX-78-2 Gundam")); // 3
        System.out.println("Count of 'MG Zaku II':        " + gunplaBag.count("MG Zaku II")); // 2
        System.out.println("Count of 'MG Wing Gundam':    " + gunplaBag.count("MG Wing Gundam")); // 0

        // Remove one occurrence of an element (simulates selling/gifting a kit).
        System.out.println("\n3. Removing one occurrence of 'HG RX-78-2 Gundam'");
        gunplaBag.remove("HG RX-78-2 Gundam");

        // Print bag contents again
        System.out.println("-Bag contents after removal-");
        System.out.println(gunplaBag);

        // Test contains() for removed element
        System.out.println("\n-Testing contains() after removal-");
        System.out.println("Contains 'HG RX-78-2 Gundam'? " + gunplaBag.contains("HG RX-78-2 Gundam")); // true (2
                                                                                                        // remain)

        // Test count() for the removed element
        System.out.println("\n-Testing count() after removal-");
        System.out.println("Count of 'HG RX-78-2 Gundam': " + gunplaBag.count("HG RX-78-2 Gundam")); // 2

        // New final step, after the removal tests
        System.out.println("\n4. Clearing the collection");
        gunplaBag.clear();
        System.out.println("-Bag contents after clear-");
        System.out.println(gunplaBag);
        System.out.println("Is the bag empty? " + gunplaBag.isEmpty()); // true
    }
}