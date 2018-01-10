# Definition for singly-linked list with a random pointer.
# class RandomListNode(object):
#     def __init__(self, x):
#         self.label = x
#         self.next = None
#         self.random = None

class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """
        if head == None:
            return head
        "Make a copy of nodes"
        hashTable = {}
        curr = head
        prev = RandomListNode(0)
        while curr:
            copy = RandomListNode(curr.label)
            prev.next = copy
            hashTable.update({curr:copy})
            curr = curr.next
            prev = prev.next
            
        curr = head
        while curr:
            hashTable.get(curr).random = hashTable.get(curr.random)
            curr = curr.next
            
        return hashTable.get(head)


class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """
        if head == None:
            return head
        "Make a copy of nodes"
        hashTable = {}
        curr = head
        prev = RandomListNode(0)
        while curr:
            if curr not in hashTable:
                copy = RandomListNode(curr.label)
                hashTable.update({curr:copy})
            if curr.next != None and curr.next not in hashTable:
                nextcopy = RandomListNode(curr.next.label)
                hashTable.update({curr.next:nextcopy})
            if curr.random != None and curr.random not in hashTable:
                randomcopy = RandomListNode(curr.random.label)
                hashTable.update({curr.random:randomcopy})
                
            if curr.next != None:
                hashTable.get(curr).next = hashTable.get(curr.next)
            if curr.random != None:
                hashTable.get(curr).random = hashTable.get(curr.random)
            curr = curr.next
            
        return hashTable.get(head)
            






























