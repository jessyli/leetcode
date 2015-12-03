// Given an array of integers, find two numbers such that they add up to a specific target number.

// The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

// You may assume that each input would have exactly one solution.

// Input: numbers={2, 7, 11, 15}, target=9
// Output: index1=1, index2=2

// Use HashMap to store the target value.

// Time complexity depends on the put and get operations of HashMap which is normally O(1).

// Time complexity of this solution is O(n).
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if(numbers==null||numbers.length<2){
            return null;
        }
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i=0; i<numbers.length; i++){
            if(hm.containsKey(target-numbers[i])){
                result[0] = hm.get(target-numbers[i])+1;
                result[1] = i+1;
                return result;
            }
            hm.put(numbers[i], i);
        }
        return null;
    }
}
