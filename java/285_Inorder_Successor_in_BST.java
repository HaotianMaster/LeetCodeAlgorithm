// Iterative version.
class Solution {
    //The inorder traversal of a BST is the nodes in ascending order. 
    //To find a successor, you just need to find the smallest one that is larger than the given value since there are no duplicate values in a BST.
    //It just like the binary search in a sorted list. 
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while (root != null) {
            if (p.val < root.val) {
                succ = root;
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        return succ;
    }
}

// Recursive version. Same logic. 
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (p.val < root.val) {
            TreeNode possible = inorderSuccessor(root.left, p);
            if (possible == null) return root;
            else return possible;
        }
        else{
            return inorderSuccessor(root.right, p);
        }
    }
}

