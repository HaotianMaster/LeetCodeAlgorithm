// If the tree is symmetric, the inorder traversal of the left subtree
// must be equal to the right-inorder traversal of the right subtree.
// Iterative solution.
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        if (root.left.val != root.right.val) return false;
        LinkedList<Integer> leftlist = new LinkedList<>();
        LinkedList<Integer> rightlist = new LinkedList<>();
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode p1 = root.left;
        TreeNode p2 = root.right;
        while ( !st.isEmpty() || p1 != null) {
            if (p1 != null) {
                st.push(p1);
                p1 = p1.left;
            }
            else {
                TreeNode curr = st.pop();
                leftlist.add(curr.val);
                p1 = curr.right;
            }
        }
        while ( !st.isEmpty() || p2 != null) {
            if (p2 != null) {
                st.push(p2);
                p2 = p2.right;
            }
            else {
                TreeNode curr = st.pop();
                rightlist.add(curr.val);
                p2 = curr.left;
            }
        }
        return leftlist.equals(rightlist);
    }
}

// Recursive solution.
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        if (root.left.val != root.right.val) return false;
        ArrayList<Integer> leftlist = new ArrayList<>();
        ArrayList<Integer> rightlist = new ArrayList<>();
        inorderTraversal(root.left, leftlist);
        rightInorderTraversal(root.right, rightlist);
        return leftlist.equals(rightlist);
    }
    public void inorderTraversal(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
    public void rightInorderTraversal(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        rightInorderTraversal(root.right, list);
        list.add(root.val);
        rightInorderTraversal(root.left, list);
    }
}




