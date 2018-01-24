/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode p1 = headA;
        ListNode p2 = headB;
        int t = 0;
        while (t<3) {
            if (p1 == p2) return p1;
            if (p1.next != null) {
                p1 = p1.next;
            }
            else {
                p1 = headB;
                t++;
            }
            if (p2.next != null) {
                p2 = p2.next;
            }   
            else {
                p2 = headA;
                t++;
            }
        }
        return null;
    }
}
