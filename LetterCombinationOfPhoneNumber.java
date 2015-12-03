Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] letters = {"abc", "def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder string = new StringBuilder();
        List<String> result = new ArrayList<String>();
        if(digits==null||digits.length()==0)
        return result;
        helper(digits, letters, string, result, 0);
        return result;
    }
    public void helper(String digits, String[] letters, StringBuilder string, List<String> result, int num){
        if(digits.length()==num){
           result.add(string.toString());
           return;
        }
        String letter = letters[digits.charAt(num)-'2'];
        for(int i=0; i<letter.length(); i++){
            string.append(letter.charAt(i));
            helper(digits, letters, string, result, num+1);
            string.deleteCharAt(string.length()-1);
        }
    }
}
