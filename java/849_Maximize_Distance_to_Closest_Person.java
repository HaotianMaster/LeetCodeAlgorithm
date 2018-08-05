// Two pointers
class Solution {
    public int maxDistToClosest(int[] seats) {
        int res = 1;
        int l = -1;
        for (int r = 0; r < seats.length; r++) {
            if (seats[r] == 1) {
                //leading zeros
                if (l == -1) res = Math.max(res, r);
                else res = Math.max(res, (r - l) / 2); //middle
                l = r;
            }
        }
        //tailing zeros
        if (seats[seats.length - 1] == 0) {
            res = Math.max(res, seats.length - 1 - l);
        }
        return res;
    }
}