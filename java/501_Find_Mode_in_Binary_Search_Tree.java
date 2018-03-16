class Solution {
    int max = Integer.MIN_VALUE;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        traverse(root, map);
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == max) list.add(key);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    public void traverse(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) return;
        if (map.containsKey(root.val)) map.put(root.val, map.get(root.val)+1);
        else map.put(root.val, 1);
        max = Math.max(max, map.get(root.val));
        traverse(root.left, map);
        traverse(root.right, map);
    }
}