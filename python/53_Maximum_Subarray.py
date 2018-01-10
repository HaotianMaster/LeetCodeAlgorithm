# bottom-up DP

class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums)==0:
            return 0
        if len(nums)==1:
            return nums[0]
        maxNum = []
        maxNum.append(nums[0])
        for i in range(len(nums)-1):
            if maxNum[i]>0:
                maxNum.append(maxNum[i]+nums[i+1])
            else:
                maxNum.append(nums[i+1])
        return max(maxNum)

# divide and conquer

class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums)==0:
            return 0
        if len(nums)==1:
            return nums[0]
        low = 0
        high = len(nums)-1
        maxNum, left, right = self.sumMaximum(nums, low, high)
        return maxNum

    def sumMaximum(self, A, low, high):
        if low==high:
            return A[low], low, low
        mid = (low+high)/2
        maxCrossMid, midLow, midHigh = self.maxSubArrayCrossMid(A, mid, low, high)
        maxRight, rightLow, rightHigh = self.sumMaximum(A, mid+1, high)
        maxLeft, leftLow, leftHigh = self.sumMaximum(A, low, mid)
        if maxCrossMid>=maxRight and maxCrossMid>=maxLeft:
            return maxCrossMid, midLow, midHigh
        elif maxRight>=maxLeft and maxRight>=maxCrossMid:
            return maxRight, rightLow, rightHigh
        else:
            return maxLeft, leftLow, leftHigh
               
    def maxSubArrayCrossMid(self, A, mid, low, high):
        sumLeft = float("-inf")  
        left = mid
        curr = 0
        for i in range(mid, low-1, -1):
            curr = curr+A[i]
            if curr>sumLeft:
                sumLeft = curr
                left = i
        sumRight = float("-inf")  
        right = mid+1
        curr = 0
        for i in range(mid+1, high+1, 1):
            curr = curr+A[i]
            if curr>sumRight:
                sumRight = curr
                right = i 
        mSum = sumLeft+sumRight
        return mSum, left, right

# One pass. O(1) space

class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums)==0:
            return 0
        if len(nums)==1:
            return nums[0]
        maxsum = float("-inf")
        currsum = 0
        for i in range(len(nums)):
            currsum = currsum+nums[i]
            maxsum = max(maxsum, currsum)
            if currsum<=0:
                currsum = 0
                
        return maxsum
