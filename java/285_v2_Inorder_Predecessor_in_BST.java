class Solution {
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (p.val <= root.val) {
            return inorderPredecessor(root.left, p);
        }
        else{
            TreeNode possible = inorderPredecessor(root.right, p);
            if (possible == null) return root;
            else return possible;            
        }
    }
}


class Solution {
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        TreeNode pred = null;
        while (root != null) {
            if (p.val <= root.val) {
                root = root.left;
            }
            else {
                pred = root;
                root = root.left;
            }
        }
        return pred;
    }
}