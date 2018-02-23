class Solution {
    int res = 0;
    public int countArrangement(int N) {  
        if (N < 1) return res;
        countHelper(N, 1, new boolean[N+1]);
        return res;
    }
    
    public void countHelper(int N, int pos, boolean[] used) {
        if (pos > N) {
            res++;
            return;
        }
        for (int num=1; num<=N; num++) {
            if (used[num] == false && (pos%num==0 || num%pos==0)) {
                used[num] = true;
                countHelper(N, pos+1, used);
                used[num] = false;
            }
        }
    }
}