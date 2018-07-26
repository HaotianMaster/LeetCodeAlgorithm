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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, res);
        return res;
    }
    public void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }
}

// Iterative solition.
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>(); 
        if (root == null) return list;
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode p = root;
        while (!st.isEmpty() || p != null) {
            if (p != null) {
                st.push(p);
                p = p.left;
            }
            else {
                TreeNode curr = st.pop();
                list.add(curr.val);
                p = curr.right;
            }
        }
        return list;
    }
}