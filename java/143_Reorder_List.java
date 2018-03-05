class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        //find the middle point.
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //reverse the right-half list.
        ListNode tail = slow.next;
        ListNode curr = slow.next.next;
        ListNode mid = slow; 
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = mid.next;
            mid.next = curr;
            tail.next = next;
            curr = next;
        }
        //Start reorder one by one
        ListNode h1 = head;
        ListNode h2 = mid.next;
        while (h1 != mid) {
            mid.next = h2.next;
            h2.next = h1.next;
            h1.next = h2;            
            h1 = h2.next;
            h2 = mid.next;
        }
    }
}

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        //find the middle point.
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //reverse the right-half list.
        ListNode curr = slow.next;
        ListNode prev = null;
        ListNode mid = slow; 
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        mid.next = prev;
        //Start reorder one by one
        ListNode h1 = head;
        ListNode h2 = mid.next;
        while (h1 != mid) {
            mid.next = h2.next;
            h2.next = h1.next;
            h1.next = h2;            
            h1 = h2.next;
            h2 = mid.next;
        }
    }
}