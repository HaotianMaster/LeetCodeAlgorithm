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
        LinkedList<Integer> list = new LinkedList<>(); 
        if (root == null) return list;
        traversal(root, list);
        return list;
    }
    public void traversal(TreeNode root, LinkedList<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        traversal(root.left, list);
        traversal(root.right, list);
    }
}
// Iterative solution.
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if(root == null) return list;
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode p = root;
        while (!st.isEmpty() || p != null) {
            if (p != null) {
                st.push(p);
                list.add(p.val);  // Add before going to children
                p = p.left;
            }
            else {
                TreeNode curr = st.pop();
                p = curr.right;
            }
        }
        return list;
    }
}