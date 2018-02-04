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
        LinkedList<Integer> list = new LinkedList<>(); 
        if (root == null) return list;
        traversal(root, list);
        return list;
    }
    public void traversal(TreeNode root, LinkedList<Integer> list) {
        if (root == null) return;
        traversal(root.left, list);
        traversal(root.right, list);
        list.add(root.val);
    }
}


// Iterative Solution
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>(); 
        if (root == null) return list;
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode p = root;
        while (!st.isEmpty() || p != null) {
            if(p != null) {
                st.push(p);
                list.addFirst(p.val);    // Reverse the process of preorder
                p = p.right;             // Reverse the process of preorder
            } else {
                TreeNode curr = st.pop();
                p = curr.left;           // Reverse the process of preorder
            }
        }
        return list;
    }

}
