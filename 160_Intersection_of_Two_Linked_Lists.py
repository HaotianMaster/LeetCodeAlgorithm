# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        if headA == None or headB == None:
            return None
        
        p1 = headA
        p2 = headB
        t=0
        while t<=1:
            if p1.val == p2.val:
                return p1
            
            if p1.next != None:
                p1 = p1.next
            else:
                p1 = headB
                t = t+1
            
            if p2.next != None:
                p2 = p2.next
            else:
                p2 = headA
        return None
