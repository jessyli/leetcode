Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null||obstacleGrid.length==0||obstacleGrid[0].length==0){
            return 0;
        }
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];
        for(int i=0; i<m; i++){
            if(obstacleGrid[i][0]!=1){
                paths[i][0]=1;
            }
            else{
                break;
            }
        }
        for(int j=0; j<n; j++){
            if(obstacleGrid[0][j]!=1){
                paths[0][j]=1;
            }
            else{
                break;
            }
        }
        for(int a=1; a<m; a++){
            for(int b=1; b<n; b++){
                if(obstacleGrid[a][b]!=1){
                    paths[a][b]=paths[a-1][b]+paths[a][b-1];
                }
                else{
                    paths[a][b]=0;
                }
            }
        }
        return paths[m-1][n-1];
    }
}
