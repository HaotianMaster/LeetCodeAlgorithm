// HashMap + PriorityQueue
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>(); 
        if (nums == null || nums.length == 0) return res;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) map.put(num, map.get(num)+1);
            else map.put(num, 1);
        }
       
        Comparator<Map.Entry<Integer, Integer>> myComparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            pcublic int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                return e2.getValue() - e1.getValue();
            }
        };
        
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(k, myComparator);
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }
        
        for (int i = 0; i < k; i++) {
            res.add(maxHeap.poll().getKey());
        }
        
        return res;
    }
}

// HashMap + Bucket Sort.
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>(); 
        if (nums == null || nums.length == 0) return res;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) map.put(num, map.get(num)+1);
            else map.put(num, 1);
        }
       
        List<Integer>[] bucket = new List[nums.length + 1];
        
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        
        for (int curr = bucket.length-1; curr >= 0 && res.size() < k; curr--) {
            if (bucket[curr] != null) {
                res.addAll(bucket[curr]);
            }
        }      
        
        return res;
    }
}