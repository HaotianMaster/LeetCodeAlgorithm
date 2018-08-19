class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        helper(root1, list1);
        helper(root2, list2);
        if (list1.size() != list2.size()) return false;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) return false;
        }
        return true;
    }
    public void helper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        helper(root.left, list);
        helper(root.right, list);
    }
}


class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
        s1.push(root1); s2.push(root2);
        while (!s1.empty() && !s2.empty())
            if (dfs(s1) != dfs(s2)) return false;
        return s1.empty() && s2.empty();
    }

    public int dfs(Stack<TreeNode> s) {
        while (true) {
            TreeNode node = s.pop();
            if (node.right != null) s.push(node.right);
            if (node.left != null) s.push(node.left);
            if (node.left == null && node.right == null) return node.val;
        }
    }
}