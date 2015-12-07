A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
Note: m and n will be at most 100.

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        if(m<=0||n<=0){
            return 0;
        }
        for(int i=0; i<m; i++){
            paths[i][0]=1;
        }
        for(int j=0; j<n; j++){
            paths[0][j]=1;
        }
        for(int a=1; a<m; a++){
            for(int b=1; b<n; b++){
                paths[a][b]=paths[a-1][b]+paths[a][b-1];
            }
        }
        return paths[m-1][n-1];
    }
}
