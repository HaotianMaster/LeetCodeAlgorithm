// The most popular solution in leetcode, very brilliant and clear. 
class Solution {
    List<Integer> res = new ArrayList<>(1000);
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null) return res;
        res.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);
        return res;
    }
    public void leftBoundary(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return;
        res.add(root.val);
        if (root.left == null) leftBoundary(root.right);
        else leftBoundary(root.left);
    }
    public void rightBoundary(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return;
        if (root.right == null) rightBoundary(root.left);
        else rightBoundary(root.right);  
        res.add(root.val);
    }
    public void leaves(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) res.add(root.val);
        leaves(root.left);
        leaves(root.right);
    }
}