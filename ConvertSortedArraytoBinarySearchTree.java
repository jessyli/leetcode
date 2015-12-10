Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

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
    public TreeNode sortedArrayToBST(int[] num) {
        if(num==null||num.length==0){
            return null;
        }
        return sorting(num, 0, num.length-1);
    }
    public TreeNode sorting(int[] num, int left, int right){
        if(left>right){
            return null;
        }
        int middle =  (left + right)/2;
        TreeNode root = new TreeNode(num[middle]);
        root.left = sorting(num, left, middle-1);
        root.right = sorting(num, middle+1, right);
        return root;
    }
}
