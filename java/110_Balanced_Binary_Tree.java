/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// A balanced tree must satisfy two conditions.
// 1. The difference between height of left and right subtree <= 1.
// 2. The left and right subtrees are balanced. 
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        // check the first condition.
        int left = treeHeight(root.left);
        int right = treeHeight(root.right);
        int diffHeight = Math.abs(left-right);
        if (diffHeight>1) return false;
        // check the second condition. 
        if (!isBalanced(root.left) || !isBalanced(root.right)) return false;
        return true;
    }
    public int treeHeight(TreeNode root) {
        if (root == null) return -1;
        if (root.left == null && root.right == null) return 0;
        int height = 1;
        int left = treeHeight(root.left);
        int right = treeHeight(root.right);
        height = height+Math.max(left, right);
        return height;
    }
}
// Better Implementation. 
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return (treeHeight(root) != -2);
    }
    public int treeHeight(TreeNode root) {
        if (root == null) return -1;
        if (root.left == null && root.right == null) return 0;
        int height = 1;
        int left = treeHeight(root.left);
        if (left == -2) return -2;
        int right = treeHeight(root.right);
        if (right == -2) return -2;
        if (Math.abs(left-right) > 1) return -2;
        height = height+Math.max(left, right);
        return height;
    }
}