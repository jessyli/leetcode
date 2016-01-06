Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn’t one, return 0 instead.
Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?

public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
      if(nums==null || nums.length==0) return 0;
      HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
      int len = 0;
      int sum = 0;
      for(int i=0; i<nums.length; i++){
        sum +=nums[i];
        if(sum == k){
          len = Math.max(len, i+1);
        }
        else if(hm.containsKey(sum-k)){
          int temp = i-hm.get(sum-k);
          len = Math.max(temp, len);
        }
        if(!hm.containsKey(sum)){
          hm.put(sum, i);
        }
      
      }
      return len;
    }
}






















