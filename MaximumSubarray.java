Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

DP
public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0||nums==null){
            return 0;
        }
        int[] localmax = new int[nums.length];
        localmax[0]=nums[0];
        int globalmax = nums[0];
        for(int i=1; i<nums.length; i++){
            
                localmax[i] = localmax[i-1]>0?nums[i]+localmax[i-1]:nums[i];
               
                globalmax = Math.max(globalmax, localmax[i]);
            
        }
        return globalmax;
    }
}

divide and conque
public class Solution {
    public int maxSubArray(int[] nums) {
       if(nums.length==0 || nums == null){
           return 0;
       }
       return helper(nums, 0, nums.length-1);
    }
    
    public int helper(int[] nums, int left, int right){
        if(left>=right){
            return nums[left];
        }
        int mid = (left+right)/2;
        int leftresult = helper(nums, left, mid);
        int rightresult = helper(nums, mid+1, right);
        int leftmax = nums[mid];
        int rightmax = nums[mid+1];
        int temp1 = 0;
        for(int i=mid; i>=left; i--){
            temp1 = temp1+nums[i];
            leftmax = Math.max(leftmax, temp1);
        }
        int temp2 = 0;
        for(int i=mid+1; i<=right; i++){
            temp2 = temp2+nums[i];
            rightmax = Math.max(rightmax,temp2);
        }
        return Math.max(Math.max(leftresult, rightresult), leftmax+rightmax);
    }
}
