// Stack. O(k) space.
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        Deque<ListNode> st = new ArrayDeque<>();
        ListNode dummy = new ListNode(-1);
        ListNode curr = head;
        dummy.next = curr;
        ListNode prev = dummy;
        while (curr != null) {
            for (int count = 0; count < k && curr != null; count++) {
                st.push(curr);
                curr = curr.next;
            }
            if (st.size() != k) return dummy.next;
            while (st.size() != 0) {
                prev.next = st.pop();
                prev = prev.next;                    
            }
            prev.next = curr; // Has to add this line.
        }
        return dummy.next;
    }
}


// O(1) space
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        ListNode last = head;
        ListNode prev = dummy;
        dummy.next = last;
        int num = 0;
        while (last != null) {
            while (num < k && last != null) {
                last = last.next;
                num++;
            }
            if (num < k) return dummy.next; 
            num = 0;
            ListNode curr = prev.next.next;
            ListNode tail = prev.next;
            while (curr != last) {
                ListNode next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
                tail.next = next;
                curr = next;
            }
            prev = tail;
        }
        return dummy.next;
    }
}