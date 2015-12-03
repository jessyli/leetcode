Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
    
time complexity O(n^2)

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE ;
        int sum = 0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            int start = i+1; 
            int end = nums.length-1;
            while(start<end){
                int temp = nums[i]+nums[start]+nums[end];
                int diff = Math.abs(temp-target);
                if(diff==0){
                    return temp;
                }
                if(diff<min){
                    min = diff;
                    sum = temp;
                }
                if(temp<target){
                    start++;
                }
                if(temp>target){
                    end--;
                }
               
            }
        }
        return sum;
    }
}
