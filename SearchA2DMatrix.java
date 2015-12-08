Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null){
            return false;
        }
        
        int n = matrix.length;
        int m = matrix[0].length;
        if(n==1&&m==1){
            if(matrix[0][0]==target){
                return true;
            }
            else{
                return false;
            }
        }
        int l = 0;
        int r = n*m-1;
        while(l<=r){
            int mid = (l+r)/2;
            int temp = matrix[mid/m][mid%m];
            if(temp==target){
                return true;
            }
            else if(temp<target){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return false;
    }
}
