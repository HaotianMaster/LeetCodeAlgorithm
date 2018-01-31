// O(nlogn) time, O(1) space.
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
// PriorityQueue, O(NlogK) time, O(K) space.
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        PriorityQueue<Integer> pq= new PriorityQueue<Integer>();
        for (int num:nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}

// Recursive QuickSort. O(nlogn) time, O(1) space.
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        quickSort(nums, 0, nums.length-1);
        return nums[nums.length-k];
    }
    public void quickSort(int[] nums, int left, int right) {
        int idx = partition(nums, left, right);
        if (left < idx - 1) { 
            quickSort(nums, left, idx - 1); 
        } 
        if (right > idx) { 
            quickSort(nums, idx, right); 
        }
    }
    public int partition(int[] nums, int left, int right) {
        //Random rand = new Random();
        //int pivotIndex = rand.nextInt(right-left+1)+left;
        //int pivot = nums[pivotIndex];
        int pivot = nums[left];
        while (left<=right) {
            while (nums[left] < pivot) {
                left++;
            }
            while (nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;               
            }
        }
        return left;
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}