import java.util.*;
public class Solution {



    public static void main(String[] arg){
        mSolution sol = new mSolution();
        int[] nums = {2, 7, 11, 15};
        sol.twoSum(nums, 26);
        System.out.println("Hello World");
    }
}


class mSolution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer>map = new HashMap<>();
        int complement;
        for (int i=0;i<nums.length;i++){
            complement = target-nums[i];
            if (map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
            System.out.println(map.get(nums[i]));
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
