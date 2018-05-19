// O(n) time since only visit each node once, in which n is the number of nodes. 
// O(1) sapce without considering the recursion stack. If consider that, there will be at most O(h) space where h is the height of the tree.
class Solution {
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }
    public int[] helper(TreeNode root) {
        if (root == null) return new int[2];
        //curr[0] denotes we don't rob curr house.
        //curr[1] denotes we rob curr house.
        int[] curr = new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        curr[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        curr[1] = root.val + left[0] + right[0];
        return curr;
    }
}