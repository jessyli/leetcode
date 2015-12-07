Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length==0 || grid[0].length==0){
            return 0;
        }
        int n = grid[0].length;
        int m = grid.length;
        int[][] sum = new int[m][n];
        sum[0][0] = grid[0][0];
        for(int i=1; i<m; i++){
            sum[i][0] = sum[i-1][0]+grid[i][0];
        }
        for(int j=1; j<n; j++){
            sum[0][j] = sum[0][j-1]+grid[0][j];
        }
        for(int a=1; a<m; a++){
            for(int b=1; b<n; b++){
                sum[a][b]= Math.min(sum[a-1][b], sum[a][b-1])+grid[a][b];
            }
        }
        return sum[m-1][n-1];
    }
}
