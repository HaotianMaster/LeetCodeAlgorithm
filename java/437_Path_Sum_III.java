// DFS AC. 
class Solution {
    int num = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        pathSumHelper(root, sum);
        pathSum(root.left, sum); 
        pathSum(root.right, sum);
        return num;
    }
    public void pathSumHelper(TreeNode root, int sum) {
        if (root == null) return;
        if (sum == root.val) num++;
        pathSumHelper(root.left, sum-root.val); 
        pathSumHelper(root.right, sum-root.val); 
    }
}

class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumHelper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    public int pathSumHelper(TreeNode root, int sum) {
        int res = 0;
        if (root == null) return 0;
        if (sum == root.val) res++;
        res += pathSumHelper(root.left, sum-root.val); 
        res += pathSumHelper(root.right, sum-root.val);
        return res;
    }
}