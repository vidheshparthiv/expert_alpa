import java.util.Arrays;

public class QuickSort {

    // Time: O(n log n) avg | O(n²) worst (sorted input with bad pivot)
    // Space: O(log n) recursion stack | Stable: No
    static void quickSort(int[] a, int low, int high) {
        if (low >= high) return;
        int pivotIdx = partition(a, low, high);
        quickSort(a, low, pivotIdx - 1);
        quickSort(a, pivotIdx + 1, high);
    }

    static int partition(int[] a, int low, int high) {
        int pivot = a[high]; // last element as pivot
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

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Before: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("After:  " + Arrays.toString(arr));
    }
}