package Opposite_Direction;
import java.util.*;
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

 
/*
Searching for a pair in sorted data — you have a sorted list and need to find two elements that combine to hit a target (sum, difference, product). Instead of checking every pair, you stand at both ends and let the comparison tell you which side to move.
Validating symmetry — checking if something reads the same forwards and backwards (strings, but also things like checking if a sequence is a "rotation" of itself, or comparing structures for mirror properties). You compare the outermost elements and walk inward.
Optimizing a value bounded by two boundaries — anytime your answer is a function of two positions (like width × height, or distance between two points), and you want to maximize/minimize it. You always shrink the "worse" boundary because the other one still has potential.
Merging from the back — when you're combining two sorted sequences into one and want to avoid overwriting data, you work backward from the highest indices instead of the front.
In-place reversal or swapping — reversing a string/array, or partitioning elements (like moving evens to one side, odds to the other) without extra space.
Fixing one element and reducing to a smaller two-pointer problem — for triplet/quadruplet style problems (sum to k, etc.), you loop over one element and then run the opposite-pointer scan on the rest. */
 
//1855
    public int maxDistance(int[] nums1, int[] nums2) {
        int dist=0,i=0,j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]>nums2[j]){i++;}
            else{
                dist=Math.max(dist, j-i);
                j++;
            }
        }
        return dist;
    }


//167
    public int[] twoSum2(int[] nums, int target) {
        int p1=0;
        int p2=nums.length-1;
        int arr[]=new int[2];
        while(p1<=p2){
            int s=nums[p1]+nums[p2];
            if(target==s){
                arr[0]=p1+1;
                arr[1]=p2+1;
                return arr;
            } 
            else if(s>target) p2--;
            else p1++;
        }
        return new int[]{-1, -1};
    }

//633
    public boolean judgeSquareSum(int c) {
        long l=0,r=(long)Math.sqrt(c);
        while(l<=r){
            long square=l*l+r*r;
            if(square==c) return true;
            else if(square>c){
                r--;
            }
            else l++;
        }
        return false;
    }

//1471
    public int[] getStrongest(int[] arr, int k) {
        int l=0,r=arr.length-1;
        Arrays.sort(arr);
        int m=arr[(arr.length-1)/2];
        int ans[]=new int [k];
        int i=0;
        while(l<=r){
            if(Math.abs(arr[l]-m)<=Math.abs(arr[r]-m)){
                ans[i++]=arr[r]; r--;
            }
            else{ans[i++]=arr[l];
                l++;}
            if(i==k) break;
        }
        return ans;
    }
}
