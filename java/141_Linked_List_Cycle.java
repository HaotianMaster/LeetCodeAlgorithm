// HashSet. O(n) time, O(n) space.
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) return true;
            else set.add(head);
            head = head.next;
        }
        return false;
    }
}
// Two pointers. O(n) time, O(1) space.
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast ) {
            if (fast == null || fast.next == null || fast.next.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}

// Two pointers. O(n) time, O(1) space.
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
