Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null){
        	return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
        	ArrayList<Integer> level = new ArrayList<Integer>();
        	int levelsize = queue.size();
        	for(int i=0; i<levelsize; i++){
        	TreeNode tem = queue.poll();
        	level.add(tem.val);
        	if(tem.left!=null){
        		queue.add(tem.left);
        	}
        	if(tem.right!=null){
        		queue.add(tem.right);
        	}
        	}
        	result.add(level);
        }
        return result;

    }
}
