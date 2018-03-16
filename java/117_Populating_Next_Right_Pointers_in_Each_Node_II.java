public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode start = root; //Keeps the start node of each level
        TreeLinkNode prev = null; //Keeps the node previous to current node we are visiting in the next level
        TreeLinkNode curr = null; //Keeps the node currently being visited
        while (start != null) {
            curr = start;
            start = null;
            prev = null;
            
            while (curr != null) {
                if (curr.left != null) {
                    //there is 2 conditions for both left and right child
                    //1. prev == null, indicating that this left or right child node is the beginning of the next level
                    //2. prev != null, indicating that this left or right child is in the middle or end of the next level
                    if (prev != null) {
                        prev.next = curr.left;
                    }
                    else {
                        start = curr.left;
                    }
                    prev = curr.left;
                }
                if (curr.right != null) {
                    if (prev != null) {
                        prev.next = curr.right;
                    }
                    else {
                        start = curr.right;
                    } 
                    prev = curr.right;
                }
                // Level order, go the next node of this level.
                curr = curr.next;
            }
        }
            
    }
}