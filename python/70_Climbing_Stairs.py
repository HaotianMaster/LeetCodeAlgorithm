# bottom-up dp

class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n==0 or n==1 or n==2:
            return n
        
        step = []
        step.append(0)
        step.append(1)
        step.append(2)
        for i in range(3,n+1):
            step.append(step[i-2]+step[i-1])
            
        return step.pop()

# top-down dp (Recursion with memorization)

class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n==0 or n==1 or n==2:
            return n
        steps = []
        steps.append(0)
        steps.append(1)
        steps.append(2)
        for i in range(3, n+1):
            steps.append(0)
        return self.possibleSteps(steps, n)
    def possibleSteps(self, stepArray, n):
        if stepArray[n]>0:
            return stepArray[n]
        stepArray[n] = self.possibleSteps(stepArray, n-1)+self.possibleSteps(stepArray, n-2)
        return stepArray[n]


# Fibonacci Number

class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n==0 or n==1 or n==2:
            return n
        
        prevprevStep = 1
        prevStep = 2
        for i in range(3,n+1):
            steps = prevStep+prevprevStep
            prevprevStep = prevStep
            prevStep = steps
            
        return steps
