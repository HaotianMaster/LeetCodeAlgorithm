// Postorder recursion. 
class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}

// Preorder iteration.
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode curr = st.pop();
            if (curr.right != null) st.push(curr.right);
            if (curr.left != null) st.push(curr.left);
            if (!st.isEmpty()) {
                curr.right = st.peek();
            }           
            curr.left = null;
        }
    }
}