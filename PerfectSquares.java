Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

public class Solution {
    public int numSquares(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int[] result = new int[n+1];
        
        
        for(int i=1; i<=n; i++){
            result[i] = i;
            for(int j=1; j*j<=i; j++){
                
                
                result[i] = Math.min(result[i], result[i-j*j]+1);
                
            }
        }
    return result[n];
    }
}
