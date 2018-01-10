# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSameTree(self, p, q):
        """
        :type p: TreeNode
        :type q: TreeNode
        :rtype: bool
        """
        
        stack = [(p,q)]

        while len(stack)>0:
            curr = stack.pop()
            if curr[0] == None and curr[1] == None:
                continue
            if curr[0] == None or curr[1] == None:
                return False
            if curr[0].val != curr[1].val:
                return False
           
            stack.append((curr[0].left, curr[1].left))
            stack.append((curr[0].right, curr[1].right))
            
        return True
        
            

class Solution(object):
    def isSameTree(self, p, q):
        """
        :type p: TreeNode
        :type q: TreeNode
        :rtype: bool
        """
        if p == None and q == None:
            return True
        if p == None or q == None:
            return False
        if p.val != q.val:
            return False

        left = self.isSameTree(p.left,q.left)
        right = self.isSameTree(p.right,q.right)

        if left != True or right != True:
            return False
        return True
        
