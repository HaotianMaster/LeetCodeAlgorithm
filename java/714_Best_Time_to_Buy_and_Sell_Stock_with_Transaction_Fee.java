class Solution {
    public int maxProfit(int[] prices, int fee) {
        int profit_hold = -prices[0]; //Hold one stock.
        int profit_zero = 0; //Hold nothing.
        for (int i = 1; i < prices.length; i++) {
            profit_zero = Math.max(profit_zero, profit_hold + prices[i] - fee);
            profit_hold = Math.max(profit_hold, profit_zero - prices[i]);
        }
        return profit_zero;
    }
}