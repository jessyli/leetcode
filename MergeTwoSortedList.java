Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(p1!=null&&p2!=null){
            if(p1.val<p2.val){
                p.next = p1;
                p1 = p1.next;
            }
            else{
                p.next = p2;
                p2= p2.next;
            }
            p = p.next;
        }
        while(p1!=null){
            p.next = p1;
            p1 = p1.next;
            p = p.next;
        }
        while(p2!=null){
            p.next = p2;
            p2 = p2.next;
            p =p.next;
        }
        return head.next;
    }
}
