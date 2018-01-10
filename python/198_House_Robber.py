# bottom-up DP. O(n) space

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums)==0:
            return 0
        if len(nums)==1:
            return nums[0]
        if len(nums)==2:
            return max(nums[0], nums[1])
        maxsum = []
        maxsum.append(nums[0])
        maxsum.append(max(nums[0], nums[1]))
        
        for i in range(2, len(nums)):
            if (maxsum[i-2]+nums[i])>maxsum[i-1]:
                maxsum.append(maxsum[i-2]+nums[i])
            else:
                maxsum.append(maxsum[i-1])
        return maxsum.pop()

# bottom-up DP. O(1) space because we actually only need to know prevsubproblem and prevprevsubproblem

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums)==0:
            return 0
        if len(nums)==1:
            return nums[0]
        if len(nums)==2:
            return max(nums[0], nums[1])
        
        prevmax = max(nums[0], nums[1])
        prevprevmax = nums[0]
        maxsum = 0
        for i in range(2, len(nums)):
            if (prevprevmax+nums[i])>prevmax:
                maxsum = prevprevmax+nums[i]
                prevprevmax = prevmax
                prevmax = maxsum
            else:
                maxsum = prevmax
                prevprevmax = prevmax
                prevmax = maxsum
        return maxsum

