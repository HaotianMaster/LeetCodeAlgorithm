class Solution(object):
    def numTrees(self, n):
        """
        :type n: int
        :rtype: int
        """
        G = []
        G.append(1)
        G.append(1)
        
        for i in range(2,n+1):
            num = 0
            for j in range(i):
                num = num+G[j]*G[i-j-1]
            G.append(num)
        return G[n]
        
