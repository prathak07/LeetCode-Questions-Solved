/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

UPDATE (2016/2/13):
The return format had been changed to zero-based indices. Please read the above updated description carefully.
*/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
        int[] res = new int[2];
        for(int i=0;i<nums.length-1;i++) {
            for(int j=i+1;j<nums.length;j++) {
                if(nums[i]+nums[j]==target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
        */
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] result = new int[2];
        
        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(nums[i])) {
                int index = map.get(nums[i]);
                result[0] = index;
                result[1] = i;
            }
            map.put(target-nums[i],i);
        }
        
        return result;
    }
}