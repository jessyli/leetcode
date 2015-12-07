Implement int sqrt(int x).

Compute and return the square root of x.

//time complexity O(logx)，space complexity O(1)
public class Solution {
    public int sqrt(int x) {
        if(x<0)
        return -1;
        if(x==0)
        return 0;
        if(x==1)
        return 1;
        long left = 0;
        long right = x/2+1;
        while(left<=right){
            long middle = (right+left)/2;
            if(middle*middle==x)
            return (int)middle;
            else if(middle*middle<x)
            left = middle+1;
            else 
            right = middle -1;
        
        }
        return (int)right;
    }
}
