Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int lastvalue = Integer.MIN_VALUE;
	private boolean firstnode = true;
	public  boolean isValidBST(TreeNode root){
		if(root==null){
			return true;
		}
		if(!isValidBST(root.left)){
			return false;
		}
		
		if(!firstnode && lastvalue>=root.val){
			return false;
		}
		firstnode=false;
		lastvalue=root.val;
			
		if(!isValidBST(root.right)){
			return false;
		}
		
	return true;
	
	}
}
