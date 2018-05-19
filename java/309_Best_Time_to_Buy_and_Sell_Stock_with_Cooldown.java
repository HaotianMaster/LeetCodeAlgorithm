class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        //buy[i] = max(rest[i-1] - price, buy[i-1]), last operation is buying.
        //sell[i] = max(buy[i-1] + price, sell[i-1]), last operation is selling.
        //rest[i] = max(buy[i-1], sell[i-1], rest[i-1]), last operation is resting.
        int buy = 0, sell = 0, rest = 0;
        int prev_buy = Integer.MIN_VALUE, prev_sell = 0, prev_rest = 0;
        for (int price : prices) {
            buy = Math.max(prev_rest - price, prev_buy);
            sell = Math.max(prev_buy + price, prev_sell);
            rest = Math.max(prev_sell, prev_rest);
            prev_buy = buy;
            prev_sell = sell;
            prev_rest = rest;
        }
        return sell;
    }
}