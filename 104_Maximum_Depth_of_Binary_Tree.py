# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

## Recursion

class Solution(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root == None:
            return 0
        
        return 1 + max(self.maxDepth(root.left), self.maxDepth(root.right))

## DFS

class Solution(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """          
        if root == None:
            return 0
        
        node_stack = [root]
        length_stack = [1]
        max_length = 0

        while len(node_stack) > 0:
            curr_node = node_stack.pop()
            curr_length = length_stack.pop()
            max_length = max(max_length, curr_length)           
            if curr_node.left != None:
                node_stack.append(curr_node.left)
                length_stack.append(curr_length+1)
            if curr_node.right != None:    
                node_stack.append(curr_node.right)
                length_stack.append(curr_length+1) 
        return max_length

## BFS

from collections import deque
class Solution(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """          
        if root == None:
            return 0
        
        node_queue = deque([root])
        length_queue = deque([1])
        max_length = 0

        while len(node_queue) > 0:
            curr_node = node_queue.popleft()
            curr_length = length_queue.popleft()
            max_length = max(max_length, curr_length)           
            if curr_node.left != None:
                node_queue.append(curr_node.left)
                length_queue.append(curr_length+1)
            if curr_node.right != None:    
                node_queue.append(curr_node.right)
                length_queue.append(curr_length+1) 
        return max_length
