class Solution {
    int res = Integer.MIN_VALUE;;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }
    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, helper(root.left)); // root.val can be negative.
        int right = Math.max(0, helper(root.right));
        res = Math.max(res, left+right+root.val);
        return Math.max(left, right)+root.val;
    }
}