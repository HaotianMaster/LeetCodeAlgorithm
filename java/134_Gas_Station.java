class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int diff = 0, len = gas.length;
        for (int i = 0; i < len; i++) {
            diff += gas[i] - cost[i];
        }
        if (diff < 0) return -1;
        int dist = 0;
        //start = start + dist - 1 because the following,
        //If the car starts at A and can not reach B. Any station between A and B
        //can not reach B.(B is the first station that A can not reach.)
        for (int start = 0; start < len; start = start + dist + 1) {
            diff = 0;
            for (dist = 0; dist < len; dist++) {
                int curr_index = (start + dist) % len;
                diff += gas[curr_index] - cost[curr_index]; 
                if (diff < 0) break;
            }
            if (dist >= len) return start;
        }
        return -1;
    }
}