class Solution {
    public int maxProfit(int[] prices) {
        int min_price = Integer.MAX_VALUE;
        int max_profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min_price) min_price = prices[i];
            else if (prices[i] - min_price > max_profit) {
                max_profit = prices[i] - min_price;
            } 
        }
        return max_profit;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0, res = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[buy] < prices[i]) {
                res = Math.max(res, prices[i] - prices[buy]);
            }
            else {
                buy = i;
            }
        }
        return res;
    }
}