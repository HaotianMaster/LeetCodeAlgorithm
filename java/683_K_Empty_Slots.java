class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        int[] days = new int[flowers.length];
        // Use an array days[] to record each position's flower's blooming day.
        // flowers[i] = x should mean that the unique flower that blooms at day i+1 (not i) will be at position x
        for(int i = 0; i < flowers.length; i++) {
            days[flowers[i] - 1] = i + 1;
        }
        int left = 0, right = k + 1, res = Integer.MAX_VALUE;
        //That means days[i] is the blooming day of the flower in position i+1. 
        //We just need to find a subarray days[left, left+1,..., left+k-1, right] 
        //which satisfies: for any i = left+1,..., left+k-1, we can have days[left] < days[i] && days[right] < days[i]. 
        //Then, the result is max(days[left], days[right]).
        for (int i = 0; right < days.length; i++) {
            if (days[i] < days[left] || days[i] <= days[right]) {
                if (i == right) res = Math.min(res, Math.max(days[left], days[right]));   //we get a valid subarray
                left = i; 
                right = k + 1 + i;
            }
        }
        return (res == Integer.MAX_VALUE) ? -1 : res;        
    }
}

// TreeSet, binary search tree
class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < flowers.length; i++) {
            int current = flowers[i];
            Integer next = treeSet.higher(current);
            if (next != null && next - current == k + 1) {
                return i + 1;
            }
            Integer pre = treeSet.lower(current);
            if (pre != null && current - pre == k + 1) {
                return i + 1;
            }
            treeSet.add(current);
        }
        return -1;        
    }
}