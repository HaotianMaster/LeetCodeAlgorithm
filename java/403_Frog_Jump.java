// DP
class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
        	return true;
        }
        //Map: key = unit, value = a set of last steps
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(0).add(0);
        
        for (int i = 0; i < stones.length; i++) {
            for (int lastStep : map.get(stones[i])) {
                for (int nextStep = lastStep - 1; nextStep <= lastStep + 1; nextStep++) {
                    if (nextStep > 0 && map.containsKey(stones[i] + nextStep)) {
                        map.get(stones[i] + nextStep).add(nextStep);
                    }
                }
            }
        }        
        //if the last unit can be reached by some steps, the Set will not be empty
        return !map.get(stones[stones.length - 1]).isEmpty();        
    }
}

// DFS