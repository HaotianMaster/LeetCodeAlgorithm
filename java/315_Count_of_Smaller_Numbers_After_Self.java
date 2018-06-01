//Time complexity: O(log1 + log2 + ... + logn) = O(log(n!)) < O(log(n^n)) = O(nlogn)
//Space complexity: O(n) for the BST.

class Solution {
    class treeNode {
        int val;
        int leftCount;
        int dup;
        treeNode left;
        treeNode right;
        public treeNode(int val, int leftCount, int dup) {
            this.val = val;
            this.leftCount = leftCount;
            this.dup = dup;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        treeNode root = null;
        Integer[] res = new Integer[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insertToBST(root,nums, res, i, 0);
        }
        return Arrays.asList(res);
    }
    public treeNode insertToBST(treeNode root, int[] nums, Integer[] res, int index, int preSum) {
        if (root == null) {
            // Current position has no treeNode yet, then we create one using current value.
            root = new treeNode(nums[index], 0, 1);
            res[index] = preSum;
            return root;
        }
        else if (root.val == nums[index]) {
            // The treeNode value in current position is same with the num, then dup++;
            root.dup++;
            res[index] = preSum + root.leftCount;
        }
        else if (root.val > nums[index]) {
            // Whenever we go left, root.leftCount++.
            root.leftCount++;
            root.left = insertToBST(root.left, nums, res, index, preSum);
        }
        else {
            // Whenever we go right, we add up the root.dup and root.leftCount, since those nums must less than the current num.
            root.right = insertToBST(root.right, nums, res, index, preSum + root.dup + root.leftCount);
        }
        return root;
    }
}