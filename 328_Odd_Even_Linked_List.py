# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def oddEvenList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head == None or head.next == None:
            return head
        l1 = odd = ListNode(-1)
        l2 = even = ListNode(-1)
        while head and head.next:
            odd.next = head
            even.next = head.next
            head = head.next.next
            odd = odd.next
            even = even.next
        if head == None:
            odd.next = l2.next
        else:
            even.next = None
            odd.next = head
            odd.next.next = l2.next
        return l1.next



# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def oddEvenList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """

        if head == None or head.next == None:
            return head
        
        t1 = odd = ListNode(0)
        t2 = even = ListNode(0)
        while head:
            odd.next = head
            even.next = head.next
            odd = odd.next
            even = even.next
            head = head.next.next if even else head.next
        odd.next = t2.next
        return t1.next
