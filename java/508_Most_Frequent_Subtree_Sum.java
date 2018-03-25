class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        //if (root == null) return int[0];
        helper(root);
        List<Integer> ans = new LinkedList<>();
        for (int sum : map.keySet()) {
            if (map.get(sum) == max) {
                ans.add(sum);
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
    
    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int sum = root.val + left + right;
        if (map.containsKey(sum)) map.put(sum, map.get(sum) + 1);
        else map.put(sum, 1);
        max = Math.max(map.get(sum), max);
        return sum;
    }
}