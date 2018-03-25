class Solution {    
    boolean res = false;
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return res;
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, k, map);
        return res;
    }
    
    public void helper(TreeNode root, int k, Map<Integer, Integer> map) {
        if (root == null) return;
        int complement = k - root.val;
        if (map.containsKey(complement)) {res = true; return;}
        else map.put(root.val, 1);
        helper(root.left, k, map);
        helper(root.right, k, map);
    }
}