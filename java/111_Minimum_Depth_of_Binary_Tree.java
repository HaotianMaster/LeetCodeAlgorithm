// Top to bot.
class Solution {
    int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        helper(root, 0);
        return min;
    }
    public void helper(TreeNode root, int depth) {
        if (root == null) return;
        if (root.left == null && root.right == null) min = Math.min(min, depth+1);
        helper(root.left, depth+1);
        helper(root.right, depth+1);
    }
}
// Bot to top.
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return left == 0 || right == 0 ? left + right + 1 : Math.min(left, right) + 1;
    }
}