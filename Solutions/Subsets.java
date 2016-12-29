/*
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

*/
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null || nums.length==0) {
            return result;
        }
        
        List<Integer> curr = new ArrayList<>();
        subsets(nums,0,curr,result);
        
        return result;
    }
    
    private void subsets(int[] nums,int start,List<Integer> curr,List<List<Integer>> result) {
        List<Integer> temp = new ArrayList<>(curr);
        result.add(temp);
        
        for(int i=start;i<nums.length;i++) {
            curr.add(nums[i]);
            subsets(nums,i+1,curr,result);
            curr.remove(curr.size()-1);
        }
    }
}