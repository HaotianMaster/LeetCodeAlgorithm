class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode middle = getMiddle(head);
        ListNode next = middle.next;
        middle.next = null;
        return merge(sortList(head), sortList(next));       
    }
    public ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                curr.next = a;
                a = a.next;
            }
            else {
                curr.next = b;
                b = b.next;               
            }
            curr = curr.next; 
        }
        if (a == null) curr.next = b;
        else curr.next = a;
        return dummy.next;
    }
}