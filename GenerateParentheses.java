Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"

public class Solution {
    public List<String> generateParenthesis(int n) {
        if(n<=0){
			return null;
		}
		ArrayList<String> result = new ArrayList<String>();
		getpair(result, "", n, n);
		return result;
        
    }
	public void getpair(ArrayList<String> result, String string, int left, int right){
		if(left>right||left<0||right<0){
			return;
		}
		if(left==0&&right==0){
			result.add(string);
			return;
		}
		getpair(result, string+"(", left-1, right);
		getpair(result, string+")", left, right-1);
    }
}
