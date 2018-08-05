// PriorityQueue
class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) return false;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i : hand){
            minHeap.add(i);
        }
        while(!minHeap.isEmpty()) {
            int start = minHeap.peek();
            for(int j = 0; j < W; j++){
                if (minHeap.remove(start + j)) {
                    continue;
                }
                else {
                    return false;
                }
            }
        }
        return true;        
    }
}

//TreeMap
//In TreeMap, call keySet(), the set's iterator returns the keys in ascending order.
class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        Map<Integer, Integer> treemap = new TreeMap<>();
        for (int i : hand) {
            treemap.put(i, treemap.getOrDefault(i, 0) + 1);
        }
        for (int it : treemap.keySet()) {
            if (treemap.get(it) > 0) {
                for (int i = 1; i < W; i++) {
                    if (treemap.getOrDefault(it + i, 0) < treemap.get(it)) return false;
                    treemap.put(it + i, treemap.get(it + i) - treemap.get(it));
                }
            }
        }
        return true;     
    }
}


