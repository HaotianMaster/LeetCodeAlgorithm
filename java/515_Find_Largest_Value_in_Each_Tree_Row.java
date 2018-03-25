// BFS
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                max = Math.max(max, curr.val);
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            res.add(max);
        }
        return res;
    }
}

// DFS, DFS is better than BFS in this case.
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        int h = getHeights(root);
        for (int i = 0; i < h; i++) res.add(Integer.MIN_VALUE);
        dfs(root, res, 0);
        return res;
    }
    public void dfs(TreeNode root, List<Integer> res, int height) {
        if (root == null) return;
        res.set(height, Math.max(root.val, res.get(height)));
        dfs(root.left, res, height + 1);
        dfs(root.right, res, height + 1);
    }
    public int getHeights(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeights(root.left), getHeights(root.right));
    }       
}