# One pass. O(n) time, O(1) space

class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        minprice = float("inf")
        maxprofit = 0
        
        for currprice in prices:
            if currprice < minprice:
                minprice = currprice 
            maxprofit = max(maxprofit, currprice-minprice)
        return maxprofit

# DP is also ok. O(n) time, O(n) space
