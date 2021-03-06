Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
	        ListNode big = new ListNode(0);
         ListNode before = small;
	        ListNode after = big;
	        
	        if(head==null){
	        	return null;
	        }
	        while(head!=null){
	        	if(head.val<x){
	        		before.next=head;
	        		before=head;
	        	}
	        	else{
	        		after.next=head;
	        		after=head;
	        	}
	        	head=head.next;
	        }
	        before.next=big.next;
	        after.next = null;
	        return small.next;
    }
    
}
