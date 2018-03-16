// Iteration. Maybe slow but real zigzag.
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        boolean leftToRight = true;
        while (!list.isEmpty()) {
            int size = list.size();
            LinkedList<Integer> clist = new LinkedList<>();
            if (leftToRight == true) {
                for (int i = 0; i < size; i++) {
                    TreeNode curr = list.remove(0);
                    clist.add(curr.val);
                    if (curr.left != null) list.add(curr.left);
                    if (curr.right != null) list.add(curr.right);
                }   
                leftToRight = false;
            }
            else {
                for (int i = 0; i < size; i++) {
                    TreeNode curr = list.remove(list.size()-1);
                    clist.add(curr.val);
                    if (curr.right != null) list.add(0, curr.right);
                    if (curr.left != null) list.add(0, curr.left);
                }     
                leftToRight = true;
            }
            res.add(clist);
        }
        return res;
    }
}

// Better iteration implementation, but actual fake zizag.
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        int leftToRight = 1;
        while (!list.isEmpty()) {
            int size = list.size();
            LinkedList<Integer> clist = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = list.remove(0);
                if (leftToRight == 1) {
                    clist.add(curr.val);
                }
                else {
                    clist.add(0, curr.val);
                }
                if (curr.left != null) list.add(curr.left);
                if (curr.right != null) list.add(curr.right);                
            }
            res.add(clist);
            leftToRight = -leftToRight;
        }
        return res;
    }
}