class Solution {
    public TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null) return new TreeNode[]{null, null};
        TreeNode[] res = new TreeNode[2];
        if (root.val <= V) {
            res = splitBST(root.right, V);
            root.right = res[0];
            res[0] = root;
        }
        else {
            res = splitBST(root.left, V);
            root.left = res[1];
            res[1] = root;
        }
        return res;
    }
}