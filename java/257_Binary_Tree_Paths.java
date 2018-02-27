// Recursive DFS.
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        pathHelper(res, root, "");
        return res;
    }
    public void pathHelper(List<String> res, TreeNode root, String path) {
        if (root.left == null && root.right == null) res.add(path + root.val);
        if (root.left != null) pathHelper(res, root.left, path + root.val + "->");
        if (root.right != null) pathHelper(res, root.right, path + root.val + "->");
    }
}

// Iterative DFS.
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> nodes = new ArrayDeque<>();
        nodes.push(root);
        Deque<String> paths = new ArrayDeque<>();
        paths.push(String.valueOf(root.val));
        while (!nodes.isEmpty()) {
            TreeNode curr = nodes.pop();
            String tmp = paths.pop();
            if (curr.left == null && curr.right == null) {
                res.add(tmp);
            }
            if (curr.left != null) {
                nodes.push(curr.left);
                paths.push(tmp + "->" + curr.left.val);
            }
            if (curr.right != null) {
                nodes.push(curr.right);
                paths.push(tmp + "->" + curr.right.val);
            }
        }
        return res;
    }
}