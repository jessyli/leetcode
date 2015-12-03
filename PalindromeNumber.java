Determine whether an integer is a palindrome. Do this without extra space.
time complexity O(n)

public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        else{
            return(x==reverse(x));
        }
    }
    public int reverse(int x){
        
        int temp = 0;

            
            while(x!=0){
                temp = temp*10+x%10;
                x=x/10;
            }
        
        return temp;
    }
}
