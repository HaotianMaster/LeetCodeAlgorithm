/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, res);
        return res;
    }
    public void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }
}


// Iterative Solution
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> st = new Stack<>();
        TreeNode p = root;
        while (!st.isEmpty() || p != null) {
            if (p != null) {
                st.push(p);
                res.add(0, p.val); // Reverse the process of preorder
                p = p.right;         // Reverse the process of preorder
            }   
            else {
                p = st.pop();
                p = p.left;          // Reverse the process of preorder
            }
        }      
        return res;
    }
}
