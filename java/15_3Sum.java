class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length <= 2) {
            return result;
        }
        Arrays.sort(nums);
        //If the first element is greater than 0 or the last element is less than 0, 
        //which means that every element in the array is greater than 0 or less than 0, 
        //respectively, indicating that we definitely cannot find a triplet whose sum is 0.
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return result;
        }  

        for (int i=0; i<nums.length-2; i++) {
            //Once we reached a element whose value is greater than 0, 
            //we know we cannot find any more triplets after it since they are all greater than 0
            if (i == 0 || nums[i] != nums[i - 1]) {
                int target = 0-nums[i];
                int low = i+1;
                int high = nums.length-1;
                while (low<high) {
                    if (nums[low]+nums[high]==target) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        //Following code is used to avoid dupilicates
                        //Once we find a triplet, we skip all the elements that is 
                        //the same with the existing one and start a new loop.
                        while (low<high && nums[low]==nums[low+1]) low++;
                        while (low<high && nums[high]==nums[high-1]) high--;
                        low++;
                        high--;
                    } else if (nums[low]+nums[high]<target) {
                        while (low<high && nums[low]==nums[low+1]) low++;
                        low++;
                    }
                    else {
                        while (low<high && nums[high]==nums[high-1]) high--;
                        high--;
                    }
                }
            }
        }
         
        return result;
    }
}





class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length<=2) {
            return result;
        }
        Arrays.sort(nums);
        if (nums[nums.length - 1]<0 || nums[0]>0) {
            return result;
        }
        for (int i=0; i<nums.length-2; i++) {
            if (i==0 || nums[i]!=nums[i-1]) {
                int target = 0-nums[i];
                int low = i+1;
                int high = nums.length-1;
                while (low<high) {
                    if (nums[low]+nums[high]==target) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low<high && nums[low]==nums[low+1]) low++;
                        while (low<high && nums[high]==nums[high-1]) high--;
                        low++;
                        high--;
                    }
                    else if (nums[low]+nums[high]<target) {
                        while (low<high && nums[low]==nums[low+1]) low++;
                        low++;
                    }
                    else {
                        while (low<high && nums[high]==nums[high-1]) high--;
                        high--;
                    }
                }
            }
        }
        return result;
    }
}
