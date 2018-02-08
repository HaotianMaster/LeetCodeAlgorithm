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
        LinkedList<Integer> leftlist = new LinkedList<>();
        LinkedList<Integer> rightlist = new LinkedList<>();
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode p1 = root.left;
        TreeNode p2 = root.right;
        leftlist = inorderTraversal(p1, leftlist);
        rightlist = rightInorderTraversal(p2, rightlist);
        return leftlist.equals(rightlist);
    }
    public LinkedList<Integer> inorderTraversal(TreeNode p, LinkedList<Integer> list) {
        if (p == null) return list;
        list = inorderTraversal(p.left, list);
        list.add(p.val);
        list = inorderTraversal(p.right, list);
        return list;
    }
    public LinkedList<Integer> rightInorderTraversal(TreeNode p, LinkedList<Integer> list) {
        if (p == null) return list;
        list = rightInorderTraversal(p.right, list);
        list.add(p.val);
        list = rightInorderTraversal(p.left, list);  
        return list;
    }
}