public class Solution {
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        if(t.left==null && t.right==null)
            return t.val+"";
        if(t.right==null)
            return t.val+"("+tree2str(t.left)+")";
        return t.val+"("+tree2str(t.left)+")("+tree2str(t.right)+")";   
    }
}


public class Solution {
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        Stack<TreeNode> st = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        st.push(t);
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            TreeNode curr = st.peek();
            if (visited.contains(curr)) {
                st.pop();
                sb.append(")");
            }
            else {
                visited.add(curr);
                sb.append("(" + curr.val);
                if (curr.left == null && curr.right != null) {
                    sb.append("()");
                }
                if (curr.right != null) {
                    st.push(curr.right);
                }
                if (curr.left != null) {
                    st.push(curr.left);
                }
            }
        }
        return sb.substring(1, sb.length() - 1);           
    }
}


