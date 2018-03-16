public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                sb.append("null ");
                continue;
            }
            sb.append(curr.val + " ");
            queue.offer(curr.left);
            queue.offer(curr.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        String[] str = data.split(" ");
        TreeNode root = new TreeNode(Integer.valueOf(str[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < str.length; i++) {
            TreeNode curr = queue.poll();
            if (!str[i].equals("null")) {
                curr.left = new TreeNode(Integer.valueOf(str[i]));
                queue.offer(curr.left);
            }
            if (!str[++i].equals("null")) {
                curr.right = new TreeNode(Integer.valueOf(str[i]));
                queue.offer(curr.right);
            }            
        }
        return root;
    }
}