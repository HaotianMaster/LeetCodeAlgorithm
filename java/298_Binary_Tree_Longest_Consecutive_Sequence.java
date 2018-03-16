class Solution {
    int res = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return res;
        helper(root, 0, root.val);
        return res;
    }
    public void helper(TreeNode root, int curr, int target) {
        if (root == null) return;
        if (target == root.val) {
            curr++;
        }
        else {
            curr = 1;
        }
        res = Math.max(curr, res);
        helper(root.left, curr, root.val+1);
        helper(root.right, curr, root.val+1);
    }
}

class Solution {
    int res = 1;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        helper(root.left, 1, root.val+1);
        helper(root.right, 1, root.val+1);
        return res;
    }
    public void helper(TreeNode root, int curr, int target) {
        if (root == null) return;
        if (target == root.val) {
            curr++;
        }
        else {
            curr = 1;
        }
        res = Math.max(curr, res);
        helper(root.left, curr, root.val+1);
        helper(root.right, curr, root.val+1);
    }
}