/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null){
            return head;
        }
        ListNode p1 = new ListNode(0);
        p1.next = head;
        int i = 1;
        ListNode pre = p1;
        while(pre.next!=null && i<m){
            pre = pre.next;
            i++;
        }
        if(i<m){
            return head;
        }
        ListNode mnode = pre.next;
        ListNode cur = mnode.next;
        while(cur!=null && i<n){
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
            mnode.next = next;
            i++;
            
        }
        return p1.next;
    }
}
