class Solution {
    int min = 0;
    int max = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, 0);
        for (int i = min; i <= max; i++) {
            res.add(new ArrayList<>());
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        index.offer(-min);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            int idx = index.poll();
            res.get(idx).add(curr.val);
            if (curr.left != null) {
                queue.offer(curr.left);
                index.offer(idx - 1);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
                index.offer(idx + 1);
            }
        }
        return res;
    }
    
    public void helper(TreeNode root, int idx) {
        if (root == null) return;
        min = Math.min(min, idx);
        max = Math.max(max, idx);
        helper(root.left, idx - 1);
        helper(root.right, idx + 1);
    }
}