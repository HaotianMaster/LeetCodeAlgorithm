// Revursive solution.
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        TreeNode root = mySortedArrayToBST(nums, 0, nums.length-1);
        return root;
    }
    public TreeNode mySortedArrayToBST(int[] nums, int left, int right) {
        if (left == right) return new TreeNode(nums[left]);
        if (right < left) return null;
        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = mySortedArrayToBST(nums, left, mid-1);
        root.right = mySortedArrayToBST(nums, mid+1, right);  
        return root;
    }
}