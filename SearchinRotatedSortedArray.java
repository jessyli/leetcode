Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0||nums==null){
            return -1;
        }
        int l = 0;
        int r = nums.length-1;
        
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[l]<=nums[mid]){
                if(target>=nums[l] && nums[mid]>=target){
                    r = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
            else if(nums[r]>=nums[mid]){
                if(target<=nums[r] && nums[mid]<=target){
                    l = mid+1;
                }
                else{
                    r = mid-1;
                }
            }
        }
        return -1; 
    }
}
