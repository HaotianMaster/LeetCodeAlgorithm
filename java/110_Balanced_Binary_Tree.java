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
        int left = depth(root.left);
        int right = depth(root.right); 
        if (Math.abs(left - right) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left, right) + 1;
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
        
        int left = treeHeight(root.left);
        if (left == -2) return -2;
        int right = treeHeight(root.right);
        if (right == -2) return -2;
        if (Math.abs(left-right) > 1) return -2;
        
        return 1 + Math.max(left, right);
    }
}