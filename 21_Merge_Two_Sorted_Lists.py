# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
# recursion
class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if l1 == None:
            return l2
        if l2 == None:
            return l1

        if l1.val<=l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        if l1.val>l2.val:
            l2.next = self.mergeTwoLists(l1, l2.next)
            return l2

# Iterative

class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if l1 == None:
            return l2
        if l2 == None:
            return l1
        
        l33 = l3 = ListNode(0)
        while l1 and l2:
            if l1.val <= l2.val:
                l3.next = l1
                l1 = l1.next
            else:
                l3.next = l2
                l2 = l2.next
            l3 = l3.next        
        
        if l1 == None:
            l3.next = l2
        if l2 == None:
            l3.next = l1
            
        return l33.next
