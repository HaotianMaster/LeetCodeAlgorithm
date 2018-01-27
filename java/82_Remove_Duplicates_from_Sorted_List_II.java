// My iterative solution.
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = new ListNode(-1);
        ListNode result = p;
        ListNode curr = head;
        if (curr.val != curr.next.val) {
            p.next = new ListNode(curr.val);
            p = p.next;            
        }
        while(curr != null && curr.next != null && curr.next.next != null) {
            if (curr.val != curr.next.val && curr.next.val != curr.next.next.val) {
                p.next = new ListNode(curr.next.val);
                p = p.next;
            }
            curr = curr.next;
        }
        if (curr.val != curr.next.val) p.next = new ListNode(curr.next.val);
        return result.next;
    }
}
//Another way of iterative solution.
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = new ListNode(-1);
        ListNode result = p;
        ListNode curr = head;
        p.next = curr;
        while(curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }  
                p.next = curr.next;
            }
            else {
                p = p.next;                
            }
            curr = curr.next; 
        }
        return result.next;
    }
}

// Recursive solution.
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        
        if (head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            head = deleteDuplicates(head.next);
        }
        else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }
}











