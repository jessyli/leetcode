Implement pow(x, n).

public class Solution {
    public double myPow(double x, int n) {
       if(n<0){
           return 1/power(x, n);
       }
       else{
           return power(x,n);
       }
    }
    public double power(double x, int n){
         if(n==0){
            return 1;
        }
        double y = power(x, n/2);
        if(n%2==0){
            return y*y;
        }
        else{
            return y*y*x;
        }
        
    }
}
