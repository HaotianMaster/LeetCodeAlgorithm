//Iteration
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        ListNode curr = head;
        ListNode prev = dummy;
        dummy.next = curr;
        while (curr != null && curr.next != null) {
            ListNode next = curr.next.next;
            prev.next = curr.next;
            curr.next.next = curr;
            curr.next = next;
            prev = curr;
            curr = next;
        }
        return dummy.next;
    }
}

//Recursion
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = head.next;
        ListNode newHead = swapPairs(head.next.next);
        node.next = head;
        head.next = newHead;
        return node;
    }
}