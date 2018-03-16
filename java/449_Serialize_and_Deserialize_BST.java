/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode curr = st.pop();
            sb.append(curr.val + " ");
            if (curr.right != null) st.push(curr.right);
            if (curr.left != null) st.push(curr.left);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        String[] str = data.split(" ");
        Queue<Integer> q = new LinkedList<>();
        for (String s : str) q.offer(Integer.valueOf(s));
        return getNode(q);
    }
    
    public TreeNode getNode(Queue<Integer> q) {
        if (q.isEmpty()) return null;
        TreeNode root = new TreeNode(q.poll());
        Queue<Integer> smallerQ = new LinkedList<>();
        while (!q.isEmpty() && q.peek() < root.val) {
            smallerQ.offer(q.poll());
        }
        root.left = getNode(smallerQ);
        root.right = getNode(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));