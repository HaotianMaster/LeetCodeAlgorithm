class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int num : G) {
            set.add(num);
        }
        int res = 0;
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            if (prev != null && !set.contains(prev.val) && set.contains(curr.val)) res++;
            else if (prev == null && set.contains(curr.val)) res++;
            prev = curr;
            curr = curr.next;
        }
        return res;
    }
}

class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int num : G) {
            set.add(num);
        }
        int res = 0;
        ListNode curr = head;
        while (curr != null) {
            if (set.contains(curr.val) && (curr.next == null || !set.contains(curr.next.val))) res++;
            curr = curr.next;
        }
        return res;
    }
}