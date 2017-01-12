/*
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/
public class Solution {
    public int firstMissingPositive(int[] nums) {
        // put numbers at the location they should be at
        for(int i=0;i<nums.length;i++) {
            while(nums[i]!=i+1 && nums[i]-1>=0 && nums[i]-1<nums.length && nums[i]!=nums[nums[i]-1]) {
                swap(nums,i,nums[i]-1);
            }
        }
        
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=i+1) {
                return i+1;
            }
        }
        
        return nums.length+1;
    }
    
    private void swap(int[] A, int i, int j){
        //display(A);
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        //display(A);
    }
    
    // private void display(int[] arr) {
    //     for(int n : arr) {
    //         System.out.print(n+" ");
    //     }
    //     System.out.println();
    // }
    /*
        Arrays.sort(nums);
        int result=1;
        for(int i=0;i<nums.length;i++) {
            if(result==nums[i]) {
                result++;
            }
            else if(result<nums[i]){
                return result;
            }
        }
        return result;
    }
    */
}