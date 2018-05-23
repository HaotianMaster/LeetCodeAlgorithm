class Solution {
    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }
    public boolean containsOne(TreeNode root) {
        if (root == null) return false;
        boolean left = containsOne(root.left);
        boolean right = containsOne(root.right);
        if (!left) root.left = null;
        if (!right) root.right = null;
        return root.val == 1 || left || right;
    }
}


class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) return null;
        return root;
    }
}