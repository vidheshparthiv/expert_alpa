import java.util.Arrays;

public class SortingAlgorithms {

    // ==================== BUBBLE SORT ====================
    // Time: O(n²) | Space: O(1) | Stable: Yes
    static void bubbleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // already sorted, exit early
        }
    }

    // ==================== SELECTION SORT ====================
    // Time: O(n²) | Space: O(1) | Stable: No
    static void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = a[minIdx];
            a[minIdx] = a[i];
            a[i] = temp;
        }
    }

    // ==================== INSERTION SORT ====================
    // Time: O(n) best, O(n²) worst | Space: O(1) | Stable: Yes
    static void insertionSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    // ==================== MERGE SORT ====================
    // Time: O(n log n) all cases | Space: O(n) | Stable: Yes
    static void mergeSort(int[] a, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(a, left, mid);
        mergeSort(a, mid + 1, right);
        merge(a, left, mid, right);
    }

    static void merge(int[] a, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = a[left + i];
        for (int j = 0; j < n2; j++) R[j] = a[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) a[k++] = L[i++];
            else               a[k++] = R[j++];
        }
        while (i < n1) a[k++] = L[i++];
        while (j < n2) a[k++] = R[j++];
    }

    // ==================== QUICK SORT ====================
    // Time: O(n log n) avg, O(n²) worst | Space: O(log n) | Stable: No
    static void quickSort(int[] a, int low, int high) {
        if (low >= high) return;
        int pivotIdx = partition(a, low, high);
        quickSort(a, low, pivotIdx - 1);
        quickSort(a, pivotIdx + 1, high);
    }

    static int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                i++;
                int temp = a[i]; a[i] = a[j]; a[j] = temp;
            }
        }
        int temp = a[i + 1]; a[i + 1] = a[high]; a[high] = temp;
        return i + 1;
    }

    // ==================== HEAP SORT ====================
    // Time: O(n log n) all cases | Space: O(1) | Stable: No
    static void heapSort(int[] a) {
        int n = a.length;

        // Step 1: build max-heap (heapify from last non-leaf to root)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(a, n, i);
        }

        // Step 2: extract max one by one
        for (int i = n - 1; i > 0; i--) {
            int temp = a[0]; a[0] = a[i]; a[i] = temp; // move max to end
            heapify(a, i, 0); // heapify the reduced heap
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
            heapify(a, n, largest); // recursively fix affected subtree
        }
    }

    // ==================== MAIN ====================
    public static void main(String[] args) {

        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone();
        int[] arr4 = arr1.clone();
        int[] arr5 = arr1.clone();
        int[] arr6 = arr1.clone();

        bubbleSort(arr1);
        System.out.println("Bubble:    " + Arrays.toString(arr1));

        selectionSort(arr2);
        System.out.println("Selection: " + Arrays.toString(arr2));

        insertionSort(arr3);
        System.out.println("Insertion: " + Arrays.toString(arr3));

        mergeSort(arr4, 0, arr4.length - 1);
        System.out.println("Merge:     " + Arrays.toString(arr4));

        quickSort(arr5, 0, arr5.length - 1);
        System.out.println("Quick:     " + Arrays.toString(arr5));

        heapSort(arr6);
        System.out.println("Heap:      " + Arrays.toString(arr6));
    }
}