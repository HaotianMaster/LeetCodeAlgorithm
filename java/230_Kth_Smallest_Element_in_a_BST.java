// Recursive inorder.
class Solution {
    int count;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return res;
    }
    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        count--;
        if (count == 0) {
            res = root.val;
            return;
        }
        helper(root.right);
    }
}

// Iterative inorder.
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode p = root;
        int count = k;
        int res = 0;
        while (!st.isEmpty() || p != null) {
            if (p != null) {
                st.push(p);
                p = p.left;
            }
            else {
                TreeNode curr = st.pop();
                count--;
                if (count == 0) {
                    res = curr.val;
                    break;
                }
                p = curr.right;
            }            
        }
        return res;
    }
}

// Divide and Conquer.
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } 
        if (k > count + 1) {
            return kthSmallest(root.right, k - 1 - count);
        }
        //k = count + 1, current node is the kth smallest node
        return root.val; 
    }
    
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }    
}

// Follow up:
// What if the BST is modified (insert/delete operations) often 
// and you need to find the kth smallest frequently? 
// How would you optimize the kthSmallest routine?

















