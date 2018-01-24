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

// My code hw1
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length<=2) return lists;
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++) {
            int target = 0-nums[i]; 
            int left = i+1; 
            int right = nums.length-1; 
            while (left<right) {
                if (nums[left]+nums[right]==target) {
                    List<Integer> templist = new ArrayList<>();
                    templist.add(nums[i]);
                    templist.add(nums[left]);
                    templist.add(nums[right]);
                    lists.add(templist);
                    while (left < nums.length-1 && nums[left]==nums[left+1]) left++;
                    while (right > 0 && nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                }
                else if (nums[left]+nums[right]<target) left++;
                else right--;
            }
            while (i <= nums.length-2 && nums[i]==nums[i+1]) i++;
        }
        return lists;
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
