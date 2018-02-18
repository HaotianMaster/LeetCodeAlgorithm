class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (sametree(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    public boolean sametree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null || s.val != t.val) return false;
        return sametree(s.left, t.left) && sametree(s.right, t.right);
    }
}