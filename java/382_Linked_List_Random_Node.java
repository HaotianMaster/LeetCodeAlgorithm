class Solution {
    ListNode head;
    Random random;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode curr = head;
        int res = head.val, i = 0;
        while (curr.next != null) {
            i++;
            curr = curr.next;
            if(random.nextInt(i + 1) == i) res = curr.val;
        }
        return res;
    }
}
