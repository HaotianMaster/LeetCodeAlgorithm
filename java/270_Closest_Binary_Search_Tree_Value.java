// Iteration.
class Solution {
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            if (Math.abs(target-root.val) < Math.abs(target-res)) {
                res = root.val;
            }
            root = root.val > target ? root.left : root.right;
        }
        return res;
    }
}
// Recursion.
class Solution {
    public int closestValue(TreeNode root, double target) {
        return helper(root, target, root.val);
    }
    public int helper(TreeNode root, double target, int val) {
        if (root == null) return val;
        if (Math.abs(target-root.val) < Math.abs(target-val)) {
            val = root.val;
        }
        if (root.val < target) val = helper(root.right, target, val);
        else if (root.val > target) val = helper(root.left, target, val);
        return val;
    }
}