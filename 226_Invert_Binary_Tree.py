# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

## Recursion

class Solution(object):
    def invertTree(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        if root == None:
            return None
        root.right = self.invertTree(root.right)
        root.left = self.invertTree(root.left)
        right = root.left
        left = root.right
        root.right = right
        root.left = left
        
        return root

## Iterative using DFS, BFS works too.

class Solution(object):
    def invertTree(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        if root == None:
            return None
        
        node_stack = [root]
        while len(node_stack)>0:
            curr_node = node_stack.pop()
            if curr_node != None:
                right = curr_node.left
                left = curr_node.right
                curr_node.right = right
                curr_node.left = left
            if curr_node.right != None:
                node_stack.append(curr_node.right)
            if curr_node.left != None:
                node_stack.append(curr_node.left)
        
        return root
