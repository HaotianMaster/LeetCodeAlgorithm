# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def mergeTrees(self, t1, t2):
        """
        :type t1: TreeNode
        :type t2: TreeNode
        :rtype: TreeNode
        """
        if t1 == None:
            return t2
        if t2 == None:
            return t1
        t1.val = t1.val+t2.val
        t1.left = self.mergeTrees(t1.left, t2.left)
        t1.right = self.mergeTrees(t1.right, t2.right) 
        return t1



class Solution(object):
    def mergeTrees(self, t1, t2):
        """
        :type t1: TreeNode
        :type t2: TreeNode
        :rtype: TreeNode
        """
        if t1 == None:
            return t2
        if t2 == None:
            return t1
        
        t1_stack = [t1]
        t2_stack = [t2]
        
        while len(t1_stack)>0 and len(t2_stack)>0:
            curr_t1 = t1_stack.pop()
            curr_t2 = t2_stack.pop()
            curr_t1.val = curr_t1.val+curr_t2.val
     
            if curr_t1.left != None and curr_t2.left != None:
                t1_stack.append(curr_t1.left)
                t2_stack.append(curr_t2.left)
            if curr_t1.right != None and curr_t2.right != None:
                t1_stack.append(curr_t1.right)
                t2_stack.append(curr_t2.right)
            if curr_t1.left == None:
                curr_t1.left = curr_t2.left
            if curr_t1.right == None:
                curr_t1.right = curr_t2.right
             
        return t1
