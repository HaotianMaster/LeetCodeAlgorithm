// DFS, get the height first and really remove the leaves level by level.
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        int h = getHeights(root);
        while (h > 0) {
            List<Integer> list = new ArrayList<>();
            leaves(root, list);
            res.add(list);
            h--;
        }
        return res;
    }
    public void leaves(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            leaves(root.left, list);
            root.left = null;
        }
        else leaves(root.left, list);
        
        if (root.right != null && root.right.left == null && root.right.right == null) {
            leaves(root.right, list);
            root.right = null;
        }
        else leaves(root.right, list);        
    }
    public int getHeights(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeights(root.left), getHeights(root.right));
    }
}


// Backtracking, we don't need to really remove the leaves level by level.
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        findLeavesHelper(root, res);
        return res;
    }
    
    public int findLeavesHelper(TreeNode root, List<List<Integer>> res) {
        if (root == null) return 0;
        int left = findLeavesHelper(root.left, res);
        int right = findLeavesHelper(root.right, res);
        int level = 1 + Math.max(left, right);
        if (res.size() == level - 1) {
            res.add(new ArrayList<>());
        }
        res.get(level - 1).add(root.val);        
        return level;
    }
}