/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Recursive solution.
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, res);
        return res;
    }
    public void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }
}
// Iterative solution.
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> st = new Stack<>();
        TreeNode p = root;
        while (!st.isEmpty() || p != null) {
            if (p != null) {
                res.add(p.val);
                st.push(p);
                p = p.left;
            }
            else {
                p = st.pop();
                p = p.right;
            }
        }
        return res;
    }
}

// Another Iterative solution.
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if(root == null) return list;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode curr = st.pop();
            list.add(curr.val); 
            if (curr.right != null) st.push(curr.right);
            if (curr.left != null) st.push(curr.left);     
        }
        return list;
    }
}