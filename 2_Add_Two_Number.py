# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if l1 == None:
            return l2
        if l2 == None:
            return l1
        carry = 0
        summ = l3 = ListNode(0)
        while l1 or l2:
            if l1 == None:
                l1 = ListNode(0)
            if l2 == None:
                l2 = ListNode(0)
            if l1.val+l2.val+carry<10:
                l3.val = l1.val+l2.val+carry
                carry = 0
            else: 
                l3.val = l1.val+l2.val+carry-10
                carry = 1
            l1 = l1.next
            l2 = l2.next  
            if l1 or l2:
                l3.next = ListNode(0)
                l3 = l3.next
        
        if carry == 1:
            l3.next = ListNode(carry)
        
        return summ
