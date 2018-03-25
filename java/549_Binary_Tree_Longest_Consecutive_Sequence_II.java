//What is the longest increasing consecutive parent-child path sequence given a root node?
//What is the longest decreasing consecutive parent-child path sequence given a root node?
//Time complexity: O(n) where n is the number of nodes in the tree.
//Space complexity: O(logn) on average for the recursion stack since this is a binary tree.
public class Solution {
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        longestPath(root);
        return max;
    }
    public int[] longestPath(TreeNode root) {
        if (root == null) return new int[] {0, 0};
        int inc = 1, dec = 1;
        if (root.left != null) {
            int[] length = longestPath(root.left);
            if (root.val + 1 == root.left.val) inc = length[0] + 1;
            if (root.val - 1 == root.left.val) dec = length[1] + 1;
        }
        if (root.right != null) {
            int[] length = longestPath(root.right);
            if (root.val + 1 == root.right.val) inc = Math.max(length[0] + 1, inc);
            if (root.val - 1 == root.right.val) dec = Math.max(length[1] + 1, dec);
        }
        max = Math.max(max, inc + dec - 1);
        return new int[] {inc, dec};
    }
}