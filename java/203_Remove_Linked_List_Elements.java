// My solution.
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        if (head.next == null && head.val == val) return null;

        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.next.val == val) p.next = p.next.next;
            else p = p.next;
        }
        if (head.val == val) return head.next;
        return head;
    }
}

// Same logic with me actually, but another implementation.
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        if (head.next == null && head.val == val) return null;

        ListNode p = head;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (p != null) {
            if (p.val == val) prev.next = p.next;
            else {
                prev.next = p;
                prev = prev.next;               
            }
            p = p.next;
        }

        return dummy.next;
    }
}

// Amazing recursive solution from someone!
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}

