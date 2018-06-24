// Using Pointers [Time Limit Exceeded]
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int l = 0, r = Integer.MAX_VALUE;
        int[] pointers = new int[nums.size()];
        boolean flag = true;
        while (flag) {
            int min = 0, max = 0;
            for (int k = 0; k < nums.size(); k++) {
                if (nums.get(min).get(pointers[min]) > nums.get(k).get(pointers[k])) min = k;
                if (nums.get(max).get(pointers[max]) < nums.get(k).get(pointers[k])) max = k;
            }
            if (r - l > nums.get(max).get(pointers[max]) - nums.get(min).get(pointers[min])) {
                r = nums.get(max).get(pointers[max]);
                l = nums.get(min).get(pointers[min]);
            }
            pointers[min]++;
            if (pointers[min] == nums.get(min).size()) flag = false;
        }
        return new int[] {l, r};
    }
}

// Using Pointers with PriorityQueue, AC. 
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int l = 0, r = Integer.MAX_VALUE;
        int[] pointers = new int[nums.size()];
        boolean flag = true;
        Comparator<Integer> mComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return nums.get(a).get(pointers[a]) - nums.get(b).get(pointers[b]);
            }
        };
        PriorityQueue<Integer> minheap = new PriorityQueue<Integer>(nums.size(), mComparator);
        int max = Integer.MIN_VALUE, min = Integer.MIN_VALUE;
        for (int k = 0; k < nums.size(); k++) {
            minheap.offer(k);
            max = Math.max(max, nums.get(k).get(pointers[k]));
        }        
        while (flag) {
            int minListIdx = minheap.poll();
            min = nums.get(minListIdx).get(pointers[minListIdx]);
            if (r - l > max - min) {
                r = max;
                l = min;
            }
            pointers[minListIdx]++;
            if (pointers[minListIdx] == nums.get(minListIdx).size()) flag = false;
            if (pointers[minListIdx] < nums.get(minListIdx).size()) {
                minheap.offer(minListIdx);
                max = Math.max(max, nums.get(minListIdx).get(pointers[minListIdx]));
            }
        }
        return new int[] {l, r};
    }
}