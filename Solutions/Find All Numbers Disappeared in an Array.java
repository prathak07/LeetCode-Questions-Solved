/*
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
*/
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0) {
                nums[index] = -nums[index];
            }
            // display(nums);
        }
        for(int i=0;i<nums.length;i++) {
            if(nums[i]>0) {
                res.add(i+1);
            }
        }
        return res;
    }
    // private void display(int[] arr) {
    //     for(int i : arr) {
    //         System.out.print(i+" ");
    //     }
    //     System.out.println();
    // }
    /*    
        List<Integer> result = new ArrayList<>();
        if(nums==null || nums.length==0) {
            return result;
        }
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        for(int i=1;i<=nums.length;i++) {
            if(map.getOrDefault(i,0)==0) {
                result.add(i);
            }
        }
        
        return result;
    }
    */
}