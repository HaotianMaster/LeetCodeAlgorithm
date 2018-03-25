// DFS.
class Solution {
    int res;
    boolean isLeft = false;
    public int findBottomLeftValue(TreeNode root) {
        int h = getHeights(root);
        dfs(root, 1, h);
        return res;
    }
    public void dfs(TreeNode root, int height, int h) {
        if (root == null) return;
        if (isLeft == false && height == h) {
            res = root.val;
            isLeft = true;
        }
        dfs(root.left, height + 1, h);
        dfs(root.right, height + 1, h);
    }
    public int getHeights(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeights(root.left), getHeights(root.right));
    }
}

// Better dfs implementation.
class Solution {
    int res = 0, h = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return res;
    }
    public void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (h < depth) {
            res = root.val;
            h++;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}