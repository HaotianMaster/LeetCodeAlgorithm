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
        if l1 == None or l2 == None:
            return None
        
        l1 = self.reverse(l1)
        l2 = self.reverse(l2)
        l3 = curr = ListNode(0)
        carry = 0
        while l1 or l2:
            curr.next = ListNode(0)
            curr = curr.next
            if l1 == None:
                l1 = ListNode(0)
            if l2 == None:
                l2 = ListNode(0)
            if l1.val+l2.val+carry<10:
                curr.val = l1.val+l2.val+carry
                carry = 0
            else:
                curr.val = l1.val+l2.val+carry-10
                carry = 1
            l1 = l1.next
            l2 = l2.next
        if carry == 1:
            curr.next = ListNode(carry)
        return self.reverse(l3.next)
    
    
    def reverse(self, head):
        prev = None
        while head:
            curr = head
            head = head.next
            curr.next = prev
            prev = curr
        return prev



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
        if l1 == None or l2 == None:
            return None

        s1 = []
        s2 = []
        while l1:
            s1.append(l1.val)
            l1 = l1.next
        while l2:
            s2.append(l2.val)
            l2 = l2.next     
        s3 = []
        carry = 0
        while len(s1)>0 or len(s2)>0:
            curr = 0
            if len(s1) == 0:
                ll1 = 0
            else:
                ll1 = s1.pop() 
            if len(s2) == 0:
                ll2 = 0
            else:
                ll2 = s2.pop()    
            if ll1+ll2+carry<10:
                curr = ll1+ll2+carry
                carry = 0
            else:
                curr = ll1+ll2+carry-10
                carry = 1
            s3.append(curr)
            
        if carry == 1:
            s3.append(carry)
        final = l3 = ListNode(0)
        while len(s3)>0:
            l3.next = ListNode(s3.pop())
            l3 = l3.next
            
        return final.next   
    
