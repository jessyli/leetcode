You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param {ListNode} l1
    # @param {ListNode} l2
    # @return {ListNode}
    def addTwoNumbers(self, l1, l2):
        if (l1==None):
            return l2
        if (l2==None):
            return l1
        if (l1==None) and (l2==None):
            return None
        head = ListNode(0)
        p = head
        carryon = 0
        while l1 or l2 or carryon:
            if l1:
                head.val = l1.val+head.val
                l1=l1.next
            if l2:
                head.val = l2.val+head.val
                l2=l2.next
            
            carryon = head.val/10
            head.val = head.val%10
            if carryon or l1 or l2:
                head.next = ListNode(carryon)
                head = head.next
            
        return p
