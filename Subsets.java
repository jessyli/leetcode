Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

Given a set S of n distinct integers, there is a relation between Sn and Sn-1. 
The subset of Sn-1 is the union of {subset of Sn-1} and {each element in Sn-1 + one more element}. 

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        if(S==null){
            return null;
        }
        Arrays.sort(S);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=0; i<S.length; i++){
          //get sets that are already in result
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            for(List<Integer> a : result){
                temp.add(new ArrayList<Integer>(a));
            }
            //add S[i] to existing sets
            for(List<Integer> a : temp){
                a.add(S[i]);
            }
            //add S[i] only as a set
            List<Integer> single = new ArrayList<Integer>();
            single.add(S[i]);
            temp.add(single);
            result.addAll(temp);
        }
        result.add(new ArrayList<Integer>());
        return result;
    }
}
