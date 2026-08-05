import java.util.Collections;
import java.util.PriorityQueue;

public class HeapPriorityQueue {
    public static void main(String[] args) {
        // Creates a Min Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // -------------------------
        // INSERT ELEMENTS
        // -------------------------

        minHeap.offer(30);
        minHeap.offer(10);
        minHeap.offer(50);
        minHeap.offer(5);
        minHeap.offer(20);

        // Heap internally arranges itself
        System.out.println("Heap : " + minHeap);

        // -------------------------
        // PEEK
        // Returns smallest element
        // Does NOT remove it
        // -------------------------

        System.out.println("Peek : " + minHeap.peek());

        // -------------------------
        // REMOVE (poll)
        // Removes smallest element
        // -------------------------

        System.out.println("Removed : " + minHeap.poll());

        System.out.println("Heap After Removal : " + minHeap);

        // -------------------------
        // SIZE
        // -------------------------

        System.out.println("Size : " + minHeap.size());

        // -------------------------
        // SEARCH
        // -------------------------

        System.out.println("Contains 20 : " + minHeap.contains(20));

        // -------------------------
        // EMPTY ?
        // -------------------------

        System.out.println("Is Empty : " + minHeap.isEmpty());

        // -------------------------
        // REMOVE SPECIFIC ELEMENT
        // -------------------------

        minHeap.remove(30);

        System.out.println("After Removing 30 : " + minHeap);

        // -------------------------
        // ITERATE
        // (NOT SORTED ORDER)
        // -------------------------

        System.out.println("Elements :");

        for (int x : minHeap) {
            System.out.print(x + " ");
        }

        System.out.println();

        // -------------------------
        // REMOVE EVERYTHING
        // Always comes in sorted order
        // -------------------------

        System.out.println("\nSorted Order:");

        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }

        // Creates Max Heap
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        // Insert
        maxHeap.offer(30);
        maxHeap.offer(10);
        maxHeap.offer(50);
        maxHeap.offer(5);
        maxHeap.offer(20);

        System.out.println("Heap : " + maxHeap);

        // Largest element
        System.out.println("Peek : " + maxHeap.peek());

        // Remove largest
        System.out.println("Removed : " + maxHeap.poll());

        System.out.println("After Removal : " + maxHeap);

        System.out.println("Contains 20 : " + maxHeap.contains(20));

        System.out.println("Size : " + maxHeap.size());

        System.out.println("Is Empty : " + maxHeap.isEmpty());

        maxHeap.remove(10);

        System.out.println("After Removing 10 : " + maxHeap);

        System.out.println("\nDescending Order:");

        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
    }
}
//bro remember remove() can be done with index as well, but PriorityQueue does not support index-based removal. You can only remove elements by value using the remove() method.
//poll removes the head of the queue, which is the smallest element.
//peek retrieves the head of the queue without removing it, which is also the smallest element.



// Method	Description	Time Complexity
// offer(x)	Insert element	O(log n)
// add(x)	Insert element (throws exception if it fails)	O(log n)
// peek()	Returns top element	O(1)
// poll()	Removes and returns top element	O(log n)
// remove()	Removes top element	O(log n)
// remove(x)	Removes a specific element	O(n)
// contains(x)	Checks if element exists	O(n)
// size()	Returns number of elements	O(1)
// isEmpty()	Checks if heap is empty	O(1)
// clear()	Removes all elements	O(n)