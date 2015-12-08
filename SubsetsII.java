Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        if(num==null){
            return null;
        }
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        int start = 0;
        for(int i=0; i<num.length; i++){
            int size = result.size();
            for(int j = start; j<size; j++){
                List<Integer> temp = new ArrayList<Integer>(result.get(j));
                temp.add(num[i]);
                result.add(temp);
            }
            if(i<num.length-1&&num[i]==num[i+1]){
                start = size;
            }
            else{
                start = 0;
            }
        }
        
        return result;
    }
}
