package Fast_And_Slow;

public class StartOfCycle {
    // LC 142 — Linked List Cycle II
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // phase 1 — detect meeting point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        if (fast == null || fast.next == null) return null; // no cycle

        // phase 2 — find cycle start
        slow = head;  // reset slow to head
        while (slow != fast) {
            slow = slow.next;  // both move 1 step
            fast = fast.next;
        }
        return slow;  // cycle start
}
}
/*
Distance from head to cycle start     = a
Distance from cycle start to meeting point = b
Distance from meeting point back to cycle start = c

When they meet:
  slow travelled = a + b
  fast travelled = a + b + b + c = a + 2b + c

fast = 2 × slow:
  a + 2b + c = 2(a + b)
  a + 2b + c = 2a + 2b
  c = a  ← distance from meeting point to start = distance from head to start

So resetting one pointer to head and moving both 1 step → they meet exactly at cycle start. */
