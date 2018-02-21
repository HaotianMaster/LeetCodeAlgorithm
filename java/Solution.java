import java.util.*;
class Solution {
    public String getPermutation(int n, int k) {
        if (k < 1 || n < 1) return "";
        List<String> res = new ArrayList<>();
        int count = 0;
        getPermutationHelper(n, k, "", count, new boolean[n], res);
        String s = res.get(k-1);
        return s;
    }
    public void getPermutationHelper(int n, int k, String curr, int count, boolean[] used, List<String> res) {
        if (count == k) return;
        if (curr.length() == n) {
            res.add(curr);
            count++;
            return;
        }
        for (int i=1; i<=n; i++) {
            if (used[i-1] == false) {
                used[i-1] = true;
                String s = Integer.toString(i);
                getPermutationHelper(n, k, curr+s, count, used, res); 
                used[i-1] = false;
            }            
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String res = sol.getPermutation(9,171669);
        System.out.println(res);
    }
}