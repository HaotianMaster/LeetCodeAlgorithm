/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//Awkward code. Think too much.....
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head;
        while (p != null && p.next != null && p.next.next != null) {
            while (p.next != null && p.val == p.next.val) {
                if (p.next.next != null) p.next = p.next.next;
                else p.next = null;
            }
            p = p.next;
        }
        if (p != null && p.next != null && p.val == p.next.val) p.next = null;
        return head;
    }
}
//Elegant code
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) p.next = p.next.next;
            else p = p.next;
        }
        return head;
    }
}