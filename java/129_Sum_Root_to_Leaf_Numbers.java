class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        helper(root, "");
        return sum;
    }
    public void helper(TreeNode root, String curr) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            curr += String.valueOf(root.val);
            sum += Integer.valueOf(curr);
            return;
        }
        helper(root.left, curr+String.valueOf(root.val));
        helper(root.right, curr+String.valueOf(root.val));
    }
}

class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        helper(root, new StringBuilder());
        return sum;
    }
    public void helper(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            sum += Integer.valueOf(sb.toString());
            sb.deleteCharAt(sb.length()-1);
            return;
        }
        helper(root.left, sb.append(root.val));
        sb.deleteCharAt(sb.length()-1);
        helper(root.right, sb.append(root.val));
        sb.deleteCharAt(sb.length()-1);
    }
}

class Solution {
    int res = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return res;
        helper(root, 0);
        return res;
    }
    public void helper(TreeNode root, int curr) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            curr = curr * 10 + root.val;
            res += curr;
            return;
        }
        helper(root.left, curr * 10 + root.val);
        helper(root.right, curr * 10 + root.val);
    }
}