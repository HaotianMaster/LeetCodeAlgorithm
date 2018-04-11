//BFS
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            res.add(0, list);
        }
        return res;        
    }
}

//DFS
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrderBottomHelper(root, res, 0);
        return res;
    }
    public void levelOrderBottomHelper(TreeNode root, List<List<Integer>> res, int level){
        if (root == null) return;
        if (level >= res.size()) {
            res.add(0, new ArrayList<Integer>());
        }
        levelOrderBottomHelper(root.left, res, level + 1);
        levelOrderBottomHelper(root.right, res, level + 1);
        res.get(res.size() - level - 1).add(root.val);
    }
}




