// Sorting first and counting. My initial stupid way.

class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length==1) {
            return nums[0];
        }
        if (nums.length==2&&nums[0]==nums[1]) {
            return nums[0];
        }
        Arrays.sort(nums);
        int occu = 1;
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i]==nums[i+1]) {
                occu = occu+1;
                if (occu>nums.length/2) {
                    return nums[i];
                }
            }
            else {
                occu = 1;
            }
        }
        return 0;
    }
}

// clever way of sorting method.

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}


// Hash table

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.replace(nums[i], map.get(nums[i])+1);
            }
            else {
                map.put(nums[i], 1);
            }
        }
        Map.Entry<Integer, Integer> me = null;
        for (Map.Entry<Integer, Integer> i:map.entrySet()) {
            if (i.getValue()>nums.length/2) {
                me = i;
                break;
            }
        }
        return me.getKey();
    }
}
