class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        //start from the second node since the first node is sorted already.
        ListNode curr = head.next;
        dummy.next = head;
        dummy.next.next = null;
        while (curr != null) {
            ListNode next = curr.next;
            ListNode prevprev = dummy;
            ListNode prev = dummy.next;
            //find the right place to insert.
			while(prev != null && prev.val < curr.val) {
				prev = prev.next;
                prevprev = prevprev.next;
			}
            //insert between prevprev and prev.
            prevprev.next = curr;
            curr.next = prev;
            curr = next;
        }
        return dummy.next;
    }
}