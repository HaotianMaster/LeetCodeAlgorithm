class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> predecessors = new Stack<>();
        Stack<Integer> successors = new Stack<>();
        inOrder(root, target, predecessors, false);
        inOrder(root, target, successors, true);
        while (k-- > 0) {
            if (predecessors.isEmpty()) {
                res.add(successors.pop());
            }
            else if (successors.isEmpty()) {
                res.add(predecessors.pop());
            }
            else if (Math.abs(predecessors.peek() - target) < Math.abs(successors.peek() - target)) {
                res.add(predecessors.pop());
            }
            else {
                res.add(successors.pop());
            }
        }
        return res;
    }
    public void inOrder(TreeNode root, double target, Stack<Integer> st, boolean reverse) {
        if (root == null) return;
        if (reverse) {
            inOrder(root.right, target, st, reverse);
        }
        else {
            inOrder(root.left, target, st, reverse);
        }
        
        if (reverse && root.val <= target || !reverse && root.val > target) return;
        st.push(root.val);
        
        if (reverse) {
            inOrder(root.left, target, st, reverse);
        }
        else {
            inOrder(root.right, target, st, reverse);
        }              
    }
}