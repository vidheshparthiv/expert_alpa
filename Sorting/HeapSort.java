import java.util.Arrays;

public class HeapSort {

    // Time: O(n log n) all cases
    // Space: O(1) | Stable: No
    static void heapSort(int[] a) {
        int n = a.length;

        // Step 1: build max-heap from bottom up
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(a, n, i);
        }

        // Step 2: extract max one by one, place at end
        for (int i = n - 1; i > 0; i--) {
            int temp = a[0]; a[0] = a[i]; a[i] = temp;
            heapify(a, i, 0);
        }
    }

    static void heapify(int[] a, int n, int i) {
        int largest = i;
        int left    = 2 * i + 1;
        int right   = 2 * i + 2;

        if (left  < n && a[left]  > a[largest]) largest = left;
        if (right < n && a[right] > a[largest]) largest = right;

        if (largest != i) {
            int temp = a[i]; a[i] = a[largest]; a[largest] = temp;
            heapify(a, n, largest); // fix the affected subtree
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Before: " + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("After:  " + Arrays.toString(arr));
    }
}