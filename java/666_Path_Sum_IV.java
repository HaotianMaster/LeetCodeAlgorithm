//Intuitively, we can construct a tree and do DFS.
//However, contructing a tree is not straightforward and hard to think.
//Notice that the position is the same as that in a full binary tree.
//Therefore, given a list of three-digits integers and a parent node, 
//we know the first two digits of the children nodes. 
//It is enough for us to perform DFS.
class Solution {
    int res = 0;
    Map<Integer, Integer> map = new HashMap();
    public int pathSum(int[] nums) {
        for (int num : nums) {
            map.put(num / 10, num % 10);
        }
        dfs(nums[0] / 10, 0);
        return res;
    }
    public void dfs(int node, int sum) {
        if (!map.containsKey(node)) return;
        sum += map.get(node);
        int depth = node / 10;
        int pos = node % 10;
        int left = (depth + 1) * 10 + 2 * pos - 1;
        int right = left + 1;
        if (!map.containsKey(left) && !map.containsKey(right)) {
            res += sum;
        }
        dfs(left, sum);
        dfs(right, sum);            
    }
}