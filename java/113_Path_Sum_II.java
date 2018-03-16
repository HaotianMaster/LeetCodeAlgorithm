class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        pathSumHelper(root, sum, res, new ArrayList<>());
        return res;
    }
    public void pathSumHelper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> list) {
        if (root.left == null && root.right == null && sum == root.val) {
            list.add(root.val);
            res.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        list.add(root.val);
        if (root.left != null) {
            pathSumHelper(root.left, sum-root.val, res, list);
        }
        if (root.right != null) {       
            pathSumHelper(root.right, sum-root.val, res, list);
        }
        list.remove(list.size()-1);
        return;
    }
}