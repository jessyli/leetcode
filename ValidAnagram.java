// Given two strings s and t, write a function to determine if t is an anagram of s.

// For example,
// s = "anagram", t = "nagaram", return true.
// s = "rat", t = "car", return false.


// 1 sort two array and compare whether eqaul. time complexity O(nlogn)
// 2 change char array to int array and minus get a int array eqaul to 0. time complexity O(n)
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s==null || t==null){
            return false;
        }
        if(s.length()!=t.length()){
            return false;
        }
        int l = s.length();
        int[] check = new int[26];
        for(int i=0; i<l; i++){
            int a = (s.charAt(i)-'a');
            int b = (t.charAt(i)-'a');
            check[a] = check[a]+1;
            check[b]= check[b]-1;
        }
        for(int j=0; j<24; j++){
            if(check[j]!=0){
               
                return false;
            }
        }
        return true;
    }
}
