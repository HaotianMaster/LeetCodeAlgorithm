/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
// Recursion. O(n) time, O(1) space.
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.next != null && root.right != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }
}

// Iteration. Using a Queue to perform BFS. O(n) time, O(n) space.
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeLinkNode curr = queue.poll();
            if (curr.left != null) {
                curr.left.next = curr.right;
            }
            if (curr.next != null && curr.right != null) {
                curr.right.next = curr.next.left;
            }
            if (curr.left != null) queue.offer(curr.left);
            if (curr.right != null) queue.offer(curr.right);
        }
    }
}

// Better iterative implementation. 
// Using TreeLinkNode to perform two perform BFS.
// (n) time, O(1) space.
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode start = root;
        while (start != null) {
            TreeLinkNode curr = start;
            while (curr != null) {
                if (curr.left != null) {
                    curr.left.next = curr.right;
                }
                if (curr.next != null && curr.right != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            start = start.left;
        }
    }
}