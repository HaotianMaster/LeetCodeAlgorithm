// DP.  Give costs[i][j] a new meaning and at the mean time save the usage of additional spaces.

class Solution {
    public int minCost(int[][] costs) {
        if (costs==null || costs.length==0) return 0;
        for (int i = 1; i < costs.length; i++) {
            costs[i][0] = costs[i][0] + Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i-1][0], costs[i-1][1]);
        }
        int size = costs.length-1;
        return Math.min(Math.min(costs[size][0], costs[size][1]), costs[size][2]);
    }
}

// Same logic actually, but no need to modify the origianl input costs[][].

class Solution {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0){
            return 0;
        }
        int one=0;
        int two=0;
        int three=0;
        for (int i=0; i<costs.length; i++) {
            int temp1 = one;
            int temp2 = two;
            int temp3 = three;
            one = costs[i][0]+Math.min(temp2, temp3);
            two = costs[i][1]+Math.min(temp1, temp3);
            three = costs[i][2]+Math.min(temp1, temp2);
        }
        return Math.min(Math.min(one, two), three);
    }
}
