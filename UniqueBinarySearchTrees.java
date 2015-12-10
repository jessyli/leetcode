Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
   
public class Solution {
    public int numTrees(int n) {
        if(n==0){
        	return 1;
        }
        if(n==1){
        	return 1;
        }
        int[] records = new int[n+1];
        records[0] = 1;
        records[1] = 1;
        records[2] = 2;
        for(int i=3; i<=n; i++){
        	int temp=0;
        	for(int k=0; k<i; k++){
        		temp=records[k]*records[i-k-1]+temp;
        	}
        	records[i]=temp;
        }
        return records[n];
    }
}
