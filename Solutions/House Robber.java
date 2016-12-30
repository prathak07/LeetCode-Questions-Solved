/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/
public class Solution {
    public int rob(int[] nums) {
        
        int ifRobbedPrevious = 0; //max money you can get if you rob the current house
        int ifDidntRobPrevious = 0; //max money you can get if you don't rob the current house
        
        //We go through all the values, we maintain two counts;
        //1. if we rob the cell
        //2. if we didn't rob the cell
        for(int i=0;i<nums.length;i++) {
            
            //if we rob current cell, previous cell shouldn't get robbed, so add the previous value to current
            int currRobbed = ifDidntRobPrevious + nums[i];
            
            //if we don't rob current cell, then the current value would be maximum of previous cell robbed and not robbed
            int currNotRobbed = Math.max(ifDidntRobPrevious , ifRobbedPrevious);
            
            //Update values for the next round
            ifRobbedPrevious = currRobbed;
            ifDidntRobPrevious = currNotRobbed;
            
        }
        
        return Math.max(ifDidntRobPrevious , ifRobbedPrevious);
        
    }
}