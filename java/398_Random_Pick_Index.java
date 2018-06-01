class Solution {
    Map<Integer, List<Integer>> map;
    Random random;
    public Solution(int[] nums) {
        map = new HashMap<>();
        random = new Random();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> list = map.get(target);
        int res = -1;
        for (int i = 0; i < list.size(); i++) {
            if (random.nextInt(i + 1) == i) res = list.get(i);
        }
        return res;
    }
}