# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeList(self, l1, l2):
        if l1 == None:
            return l2
        if l2 == None:
            return l1
        l3 = curr = ListNode(-1)
        while l1 != None and l2 != None:
            if l1.val <= l2.val:
                curr.next = l1
                l1 = l1.next
            else:
                curr.next = l2
                l2 = l2.next
            curr = curr.next
        if l1 == None:
            curr.next = l2
        else:
            curr.next = l1
        return l3.next
    
    def sortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        
        if head == None or head.next == None:
            return head
        mid = head
        p1 = head
        p2 = head
        while p2 != None and p2.next != None:
            mid = p1
            p1 = p1.next
            p2 = p2.next.next
        mid.next = None
        
        h1 = self.sortList(head)
        h2 = self.sortList(p1)
        
        return self.mergeList(h1, h2)
        
