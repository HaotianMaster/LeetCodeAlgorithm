public class BSTIterator {
    TreeNode root;
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.root = root;
        this.st = new Stack<>();
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (!st.isEmpty()) return true;
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode curr = st.pop();
        int res = curr.val;
        if (curr.right != null) {
            curr = curr.right;
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
        }
        return res;
    }
}