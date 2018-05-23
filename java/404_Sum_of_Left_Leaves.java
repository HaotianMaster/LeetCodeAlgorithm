class Solution {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        helper(root.left, true);
        helper(root.right, false);
        return sum;
    }
    public void helper(TreeNode root, boolean isLeft) {
        if (root == null) return;
        if (root.left == null && root.right == null && isLeft == true) sum += root.val;
        helper(root.left, true);
        helper(root.right, false);        
    }
}