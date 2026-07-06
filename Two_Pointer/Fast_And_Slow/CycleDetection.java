package Fast_And_Slow;

public class CycleDetection {
    // LC 141 — Linked List Cycle
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // 1 step
            fast = fast.next.next;   // 2 steps

            if (slow == fast) return true;  // met → cycle exists
        }
        return false;  // fast hit null → no cycle
    }
}
/*
1 → 2 → 3 → 4 → 5 → 3 (cycle back to node 3)

start: slow=1, fast=1
step1: slow=2, fast=3
step2: slow=3, fast=5
step3: slow=4, fast=4  → met! cycle exists  */

//287 — Find the Duplicate Number
     public int findDuplicate(int[] nums) {
        int fast=nums[0];
        int slow=nums[0];
        while(true){
            slow=nums[slow];
            fast=nums[nums[fast]];
            if(slow==fast) break;
        }
        slow=nums[0];
        while(true){
            if(slow==fast) return slow;
            slow=nums[slow];
            fast=nums[fast];

        }
    }

//202
public int fun(int x){
        int ans=0;
        while(x!=0){
            int r=x%10;
            x/=10;
            ans+=r*r;
        }
        return ans;
    }
    public boolean isHappy(int n) {
        int slow=n;
        int fast=fun(n);
        while(fast!=1&&fast!=slow){
            slow=fun(slow);
            fast=fun(fun(fast));
        }
        return fast==1;
    }
/*    Slow pointer starts at the original number n.

    Fast pointer starts at getNext(n) (one step ahead).

This setup is intentional because:

    Avoids trivial equality: If both started at n, the loop condition slow != fast would fail immediately, and you’d incorrectly conclude there’s a cycle.

    Ensures movement: By advancing fast once before the loop, you guarantee that the fast pointer is always ahead, so the cycle detection works properly.

    Consistency with Floyd’s algorithm: In linked list cycle detection, the fast pointer usually starts one step ahead to prevent false positives at the beginning. */