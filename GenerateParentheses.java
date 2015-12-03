Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"

public class Solution {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // Write your code here
        if(s==null || s.length()==0){
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }
            if(s.charAt(i)==')'||s.charAt(i)=='}'||s.charAt(i)==']'){
                if(stack.size()==0){
                    return false;
                }
                if(stack.peek()=='('&&s.charAt(i)==')'){
                    stack.pop();
                    continue;
                }
                if(stack.peek()=='{'&&s.charAt(i)=='}'){
                    stack.pop();
                    continue;
                }
                if(stack.peek()=='['&&s.charAt(i)==']'){
                    stack.pop();
                    continue;
                }
                else{
                    return false;
                }
            }
            
        }
        if(stack.size()==0){
            return true;
        }
        else{
            return false;
        }
        
        
       
    }
}
