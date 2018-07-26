// Logic is correct, but time limit exceed.
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
}

// AC
class Solution {
    public String getPermutation(int n, int k) {
        if (n < 1 || k < 1) return "";
        List<Integer> nums = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int[] factorial = new int[n];
        //Get factorial n-1 to factorial 1.
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        //Prestore all the nums in ascending order.
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        
        k--;
        for (int i = 0; i < n; i++) {
            sb.append(nums.remove(k / factorial[n - i - 1]));
            k %= factorial[n - i - 1];
        }
        
        return sb.toString();
    }
}




