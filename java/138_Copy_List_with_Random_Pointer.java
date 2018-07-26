// Using map, an intuitive solution. 
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(0);
        dummy.next = head;
        RandomListNode curr = head;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (curr != null) {
            RandomListNode copy = new RandomListNode(curr.label);
            map.put(curr, copy);
            curr = curr.next;
        }      
        curr = dummy.next;
        while (curr != null) {
            RandomListNode copy = map.get(curr);
            if (curr.next != null) copy.next = map.get(curr.next);
            if (curr.random != null) copy.random = map.get(curr.random);
            curr = curr.next;
        }              
        return map.get(dummy.next);
    }
}