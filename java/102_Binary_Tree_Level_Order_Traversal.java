//BFS
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                list.add(curr.val);
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            res.add(list);
        }
        return res;
    }
}

//DFS
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrderHelper(root, res, 0);
        return res;
    }
    public void levelOrderHelper(TreeNode root, List<List<Integer>> res, int level){
        if (root == null) return;
        if (level >= res.size()) {
            res.add(new ArrayList<Integer>());
        }
        levelOrderHelper(root.left, res, level + 1);
        levelOrderHelper(root.right, res, level + 1);
        res.get(level).add(root.val);
    }
}