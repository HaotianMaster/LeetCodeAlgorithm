// PriorityQueue. O(nklogk) time. O(k) space. 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        Comparator<ListNode> cmp = new Comparator<ListNode>() {
            @Override
            public int compare (ListNode n1, ListNode n2) {
                return n1.val-n2.val;
            }
        };
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, cmp);
        for (ListNode list : lists) {
            if (list != null) pq.add(list);
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null) pq.add(node.next);
        }
        return dummy.next;
    }
}