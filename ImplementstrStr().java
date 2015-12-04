Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack==null || needle == null || needle.length()==0){
            return 0;
        }
        if(needle.length()>haystack.length()){
            return -1;
        }
        for(int i=0; i< haystack.length()-needle.length()+1; i++){
            boolean success = true;
            for(int j = 0; j<needle.length(); j++){
                if(needle.charAt(j)!=haystack.charAt(i+j)){
                    success = false;
                    break;
                }
            }
            if(success == true){
                return i;
            }
        }
        return -1;
    }
}
