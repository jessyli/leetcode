Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections.

Note: The path does not need to go through the root.

For example,
   4
  / \
 1   3
    / \
   2   5
Longest consecutive sequence path is 2-3-4, so return 3.
   5
  / \
 2   3
    / \
   2   4
  / \
 3   1
Longest consecutive sequence path is 1-2-3-4, so return 4.


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
    public int longestConsecutive(TreeNode root) {
        if(root==null){
             return 0;
         }
         return helper(root, 0, null);
    }
    public int helper(TreeNode now, int length, TreeNode parent){
         if(now==null){
             return length;
         }
         if(parent==null || (now.val == parent.val+1)){
             length = length+1;
         }
         else{
             length = 1;
         }
         return max(length, helper(now.right, length, now));
         
     }
}


