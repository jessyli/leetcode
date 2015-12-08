A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.

public class Solution {
    public int numDecodings(String s) {
       if(s==null||s.length()==0||s=="0"){
           return 0;
       }
       int[] result = new int[s.length()+1];
       result[0] = 1;
       if(s.charAt(0)=='0'){
           result[1] = 0;
       }
       else{
           result[1] = 1;
       }
       for(int i=2; i<=s.length(); i++){
           if(isValide(s.substring(i-1, i))){
               result[i] = result[i-1];
           }
           if(isValide(s.substring(i-2, i))){
               result[i] = result[i-2]+result[i];
           }
       }
       return result[s.length()];
    }
    
    public boolean isValide(String s){
        if(s.charAt(0)=='0'){
            return false;
        }
        int Value = Integer.parseInt(s);
        if(Value>=1 && Value<=26){
            return true;
        }
        else{
            return false;
        }
    }
}
