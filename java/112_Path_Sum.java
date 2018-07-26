class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && sum == root.val) return true;
        boolean left = hasPathSum(root.left, sum - root.val);
        boolean right = hasPathSum(root.right, sum - root.val);
        return left || right;
    }
}

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return helper(root, sum, 0);
    }
    public boolean helper(TreeNode root, int sum, int curr) {
        if (root == null) return false;
        curr += root.val;
        if (root.left == null && root.right == null) return curr == sum;
        return helper(root.left, sum, curr) || helper(root.right, sum, curr);
    }
}