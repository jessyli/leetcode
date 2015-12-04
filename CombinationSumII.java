Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		if(num.length<1){
			return result;
		}
		List<Integer> path = new ArrayList<Integer>();
		Arrays.sort(num);
		combination(num, target, path, 0);
		return result;
	}
	public void combination(int[] num, int target, List<Integer> path, int start){
		if(target==0){
			result.add(new ArrayList<Integer>(path));

		}
		if(target<0||start>=num.length){
			return;
		}
		for(int i=start; i<num.length;i++){
			if(i>start&&num[i]==num[i-1]){
				continue;
			}
			path.add(num[i]);
			combination(num, target-num[i], path, i+1);
			path.remove(path.size()-1);
		}
	}
}
