Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 

public class Solution {
    public List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length<1) return result;
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<Integer>();
        dfs(candidates, target, path, 0);
        return result;
    }
    
    public void dfs(int[] candidates, int target, List<Integer> path, int start){
        if(target==0){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        if(target<0 || start>=candidates.length){
            return;
        }
        for(int i=start; i<candidates.length; i++){
            path.add(candidates[i]);
            dfs(candidates, target-candidates[i], path, i);
            path.remove(path.size()-1);
        }
    }
}
