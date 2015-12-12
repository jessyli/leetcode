/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    static ListNode h;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        int count = 0;
        ListNode cur = head;
        while(cur!=null){
            cur = cur.next;
            count++;
        }
        h = head;
        return helper(0, count-1);
      
    }
    public TreeNode helper(int l, int r){
        if(l>r){
            return null;
        }
        
        int mid = (l+r)/2;
        TreeNode left = helper(l, mid-1);
        TreeNode root = new TreeNode(h.val);
        h = h.next;
        TreeNode right = helper(mid+1, r);
        root.left = left;
        root.right = right;
        
        return root;
        
    }
}
