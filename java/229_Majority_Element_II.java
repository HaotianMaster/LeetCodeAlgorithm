class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums==null || nums.length==0) return res;
        int number1 = 0; int number2 = 0;
        int count1 = 0; int count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == number1) {
                count1++;
            }
            else if (nums[i] == number2) {
                count2++;
            }
            else if (count1 == 0) {
                number1 = nums[i];
                count1 = 1;
            }
            else if (count2 == 0) {
                number2 = nums[i];
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == number1) count1++;
            if (nums[i] == number2) count2++;
        }
        if (count1 > nums.length / 3) res.add(number1);
        if (count2 > nums.length / 3 && number1 != number2) res.add(number2);
        return res;
    }
}



