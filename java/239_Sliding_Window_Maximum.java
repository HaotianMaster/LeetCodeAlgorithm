// PriorityQueue O(nlogn) time, O(k) space.
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[]{};
        Comparator<Integer> mComparator = new Comparator<Integer>() {
            @Override 
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        };
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, mComparator);
        int[] res = new int[nums.length - k + 1];
        
        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }
        
        for (int i = 0; i < res.length; i++) {
            res[i] = pq.peek();
            pq.remove(nums[i]);
            if (i + k < nums.length)
                pq.offer(nums[i + k]);
        }
        return res;
    }
}

//O(n)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[]{};
        int l = nums.length;
        int[] res = new int[l - k + 1];
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < l; i++) {
            // Remove the out of boundary element. i-k+1 is the left boundary of the window.
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            // Remove all the previous elements that less than nums[i]
            // becasue these elements have no chance to be the max.
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            deque.offer(i);
            
            if (i >= k - 1) {
                res[index++] = nums[deque.peek()];
            }
        }
        
        return res;
    }
}