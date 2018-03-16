// Recursion.
class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        if (root == null) return;       
        inorderTraversal(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    public void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null) first = prev;
            second = root;
        }
        prev = root;
        inorderTraversal(root.right);
    }
}

// Iteration. 
class Solution {
    public void recoverTree(TreeNode root) {
        if (root == null) return; 
        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = null;
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while (!st.isEmpty() || curr != null) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            else {
                curr = st.pop();
                if (prev != null && prev.val > curr.val) {
                    if (first == null) first = prev;
                    second = curr;
                }   
                prev = curr;
                curr = curr.right;
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}