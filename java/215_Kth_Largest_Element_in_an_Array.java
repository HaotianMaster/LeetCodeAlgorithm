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

// Recursive QuickSort. Better implementation.
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int i = 0, j = nums.length - 1;
        k = nums.length-k;
        quicksort(nums, i, j);
        return nums[k];
    }
    
    private void quicksort(int[] nums, int low, int high) {
        int p = partition(nums, low, high);
        if (low < p-1) {
            quicksort(nums, low, p-1);
        }
        if (high > p+1) {
            quicksort(nums, p+1, high);
        }
    }
    
    private int partition(int[] nums, int low, int high) {
        int l = low + 1;
        int r = high;
        while(l <= r) {
            if(nums[l] < nums[low]) {
                l++;
            } else {
                swap(nums, l, r);
                r--;
            }
        }
        swap(nums, low, r);
        return r;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }    
}


//John's solution. QuickSelect. 
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        k = nums.length-k;
        while (low < high) {
            int p = partition(nums, low, high);
            if (p < k) {
                low = p + 1;
            }
            else if (p > k) {
                high = p - 1;
            }
            else break;
        }
        return nums[k];
    }
    
    private int partition(int[] nums, int low, int high) {
        int l = low + 1;
        int r = high;
        while(l <= r) {
            if(nums[l] < nums[low]) {
                l++;
            } else {
                swap(nums, l, r);
                r--;
            }
        }
        swap(nums, low, r);
        return r;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }    
}