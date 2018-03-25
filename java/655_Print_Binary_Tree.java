// Preorder Recursion 
class Solution {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        if (root == null) return res;
        int rows = getHeights(root);
        int columns = (int) Math.pow(2, rows) - 1;
        List<String> row = new ArrayList<>();
        for (int i = 0; i < columns; i++) row.add("");
        for (int i = 0; i < rows; i++) res.add(new ArrayList<>(row));
        helper(root, res, 0, rows, 0, columns - 1);
        return res;
    }
    
    public void helper(TreeNode root, List<List<String>> res, int row, int rows, int left, int right) {
        if (root == null || row == rows) return;
        int mid = left + (right - left) / 2;
        res.get(row).set(mid, String.valueOf(root.val));
        helper(root.left, res, row + 1, rows, left, mid - 1);
        helper(root.right, res, row + 1, rows, mid + 1, right);
    }
    
    public int getHeights(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeights(root.left), getHeights(root.right));
    }
}

// Level order iteration. 
class Solution {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        if (root == null) return res;
        int rows = getHeights(root);
        int columns = (int) Math.pow(2, rows) - 1;
        List<String> row = new ArrayList<>();
        for (int i = 0; i < columns; i++) row.add("");
        for (int i = 0; i < rows; i++) res.add(new ArrayList<>(row));
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<int[]> index = new LinkedList<>();
        int rowNumber = -1;
        nodes.offer(root);
        index.offer(new int[] {0, columns - 1});
        while (!nodes.isEmpty()) {
            rowNumber++;
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = nodes.poll();
                int pos[] = index.poll();
                int mid = (pos[0] + pos[1]) / 2;
                res.get(rowNumber).set(mid, String.valueOf(curr.val));
                if (curr.left != null) {
                    nodes.offer(curr.left);
                    index.offer(new int[] {pos[0], mid - 1});
                }
                if (curr.right != null) {
                    nodes.offer(curr.right);
                    index.offer(new int[] {mid + 1, pos[1]});
                }
            }
        }     
        return res;
    }
    
    public int getHeights(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeights(root.left), getHeights(root.right));
    }
}