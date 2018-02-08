// Bute force. 
// In the recursion process, we could see that 
// a lot of subproblems were calculated multiple times.
// Finally, time limit exceeded.  
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        return myCoinChange(coins, amount);
    }
    public int myCoinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        int min = Integer.MAX_VALUE;
        for (int coin:coins) {
            int submin = myCoinChange(coins, amount-coin);
            if (submin >= 0) min = Math.min(min, submin+1);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}

// Top-down DP solution or recursive solution. 
// Therefore we cache the solutions to the subproblems in a table 
// and access them in constant time when necessary.
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        return myCoinChange(coins, amount, new int[amount+1]);
    }
    public int myCoinChange(int[] coins, int amount, int[] count) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        int min = Integer.MAX_VALUE;
        for (int coin:coins) {
            int submin = -1;
            if (amount-coin >= 0 && count[amount-coin] != 0) submin = count[amount-coin];
            else submin = myCoinChange(coins, amount-coin, count);
            if (submin >= 0) min = Math.min(min, submin+1);
        }
        count[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return count[amount];
    }
}

// Bottom-up DP solution or iterative solution.

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        int[] count = new int[amount+1];
        Arrays.fill(count, amount+1);  
        count[0] = 0; 
        for (int curramount = 1; curramount <= amount; curramount++) {
            for (int coin:coins) {
                if (coin <= curramount) {
                    count[curramount] = Math.min(count[curramount], count[curramount - coin] + 1);
                }                
            }
        }   
        return count[amount] > amount ? -1 : count[amount];
    }
}







