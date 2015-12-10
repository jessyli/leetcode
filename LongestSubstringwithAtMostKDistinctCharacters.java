Given a string s, find the length of the longest substring T that contains at most k distinct characters.
Example
For example, Given s = "eceba", k = 3,

T is "eceb" which its length is 4.

Challenge
O(n), n is the size of the string s.

public class Solution {
    /**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if(s==null || k==0 || s.length()==0){
            return 0;
        }
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        int maxlength= 0;
        int start = 0;
        int end = 0;
        while(end<s.length()){
            if(hm.size()<k && !hm.containsKey(s.charAt(end))){
                hm.put(s.charAt(end), 1);
                maxlength = Math.max(maxlength, end-start+1);
            }
            else if(hm.size()<=k && hm.containsKey(s.charAt(end))){
                int temp = hm.get(s.charAt(end));
                    temp = temp+1;
                    hm.put(s.charAt(end), temp);
                    maxlength = Math.max(maxlength, end-start+1);
            }
            else{
                maxlength = Math.max(maxlength, end-start);
                hm.put(s.charAt(end), 1);
                while(hm.size()>k){
                    int temp = hm.get(s.charAt(start));
                    if(temp==1){
                        hm.remove(s.charAt(start));
                    }
                    else{
                        temp--;
                        hm.put(s.charAt(start), temp);
                    }
                    start++;
                }
                    
            }
            end++;
        }
        return maxlength;
    }
}
