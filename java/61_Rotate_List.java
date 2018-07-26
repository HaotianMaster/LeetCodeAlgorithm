class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        int l;       
        for (l = 0; fast.next != null; l++) //Get the total length 
            fast=fast.next;
        
        k = k%l;
        for (int i = 0; i < l-k; i++) {
            slow = slow.next;
        }

        fast.next = head;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        k = k % len;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }
}