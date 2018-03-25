// O(logn * logn) time
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = leftDepth(root);
        int right = rightDepth(root);
        if (left == right) {
            return (1 << left) - 1;
        }
        else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
    
    public int leftDepth(TreeNode root) {
        int res = 0;
        while (root != null) {
            root = root.left;
            res++;
        }
        return res;
    }
    public int rightDepth(TreeNode root) {
        int res = 0;
        while (root != null) {
            root = root.right;
            res++;
        }
        return res;
    }
}