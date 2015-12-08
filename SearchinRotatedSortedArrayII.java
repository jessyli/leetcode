Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.

public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return false;
        }
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target){
                return true;
            }
            if(nums[l]<nums[mid]){
                if(nums[l]<=target&&nums[mid]>target){
                    r = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
            else if(nums[l]>nums[mid]){
                if(nums[r]>=target&&nums[mid]<target){
                    l = mid+1;
                }
                else{
                    r = mid-1;
                }
            }
            else{
                l = l+1;
            }
            
        }
        return false;
    }
}
