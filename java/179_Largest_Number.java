class Solution {
    public String largestNumber(int[] nums) {
        Comparator<String> mComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String num1 = s1 + s2;
                String num2 = s2 + s1;
                return num2.compareTo(num1);
            }
        };
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, mComparator);
        if (strs[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }
}