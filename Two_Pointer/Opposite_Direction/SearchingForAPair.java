package Opposite_Direction;

/*
Why It Only Works on Sorted Arrays
The whole trick relies on monotonicity: moving left right always increases the sum, moving right left always decreases the sum. This only holds true if the array is sorted.
sorted:   [1, 3, 5, 7, 9]
           ↑           ↑
         left        right

sum too small → left++ → sum can only go UP (next value ≥ current)
sum too large → right-- → sum can only go DOWN (next value ≤ current)
If the array were unsorted, moving a pointer wouldn't guarantee the sum moves predictably — you'd be back to brute force. */

class SearchingForAPair {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
 
/*
Searching for a pair in sorted data — you have a sorted list and need to find two elements that combine to hit a target (sum, difference, product). Instead of checking every pair, you stand at both ends and let the comparison tell you which side to move.
Validating symmetry — checking if something reads the same forwards and backwards (strings, but also things like checking if a sequence is a "rotation" of itself, or comparing structures for mirror properties). You compare the outermost elements and walk inward.
Optimizing a value bounded by two boundaries — anytime your answer is a function of two positions (like width × height, or distance between two points), and you want to maximize/minimize it. You always shrink the "worse" boundary because the other one still has potential.
Merging from the back — when you're combining two sorted sequences into one and want to avoid overwriting data, you work backward from the highest indices instead of the front.
In-place reversal or swapping — reversing a string/array, or partitioning elements (like moving evens to one side, odds to the other) without extra space.
Fixing one element and reducing to a smaller two-pointer problem — for triplet/quadruplet style problems (sum to k, etc.), you loop over one element and then run the opposite-pointer scan on the rest. */