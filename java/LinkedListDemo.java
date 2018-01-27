import java.util.*;
public class LinkedListDemo {
	public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    }

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

    public static void main(String args[]) {
        ListNode q1 = new ListNode(1);
        ListNode q2 = new ListNode(2);
        ListNode q3 = new ListNode(2);
		q1.next = q2;
		q2.next = q3;
 		LinkedListDemo demo = new LinkedListDemo();
 		demo.deleteDuplicates(q1);

    }
}

