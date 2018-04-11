class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null;
        return buildTreeHelper(preorder, inorder, 0, 0, inorder.length - 1);
    }
    
    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int pre_start, int in_start, int in_end) {
        if (in_start > in_end) return null;
        TreeNode curr = new TreeNode(preorder[pre_start]);
        int i = in_start;
        while (i <= in_end) {
            if (inorder[i] == preorder[pre_start]) break;
            i++;
        }
        curr.left = buildTreeHelper(preorder, inorder, pre_start + 1, in_start, i - 1);
        curr.right = buildTreeHelper(preorder, inorder, pre_start + i - in_start + 1, i + 1, in_end);
        return curr;
    }
}