#!/usr/bin/python

class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def reverseBetween(self, head, m, n):
        if m == n:
            return head

        dummyNode = ListNode(0)
        dummyNode.next = head
        pre = dummyNode

        for i in range(m - 1):
            pre = pre.next
        

        reverse = None
        M = pre.next        
        for i in range(n - m + 1):
            curr = M
            M = M.next
            curr.next = reverse
            reverse = curr

        pre.next.next = M   
        pre.next = reverse
       

        return dummyNode.next


A = ListNode(1)
B = ListNode(2)
C = ListNode(3)
D = ListNode(4)
E = ListNode(5)
F = ListNode(6)

A.next = B
B.next = C
C.next = D
D.next = E
E.next = F

sol = Solution()
sol.reverseBetween(A,2,4)
