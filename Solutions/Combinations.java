/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(k==0) {
            return result;
        }
        
        int[] nums = new int[n];
        for(int i=0;i<nums.length;i++) {
            nums[i] = i+1;
        }
        
        List<Integer> curr = new ArrayList<>();
        combine(nums,k,curr,result,0);
        
        return result;
    }
    
    private void combine(int[] nums,int len,List<Integer> curr,List<List<Integer>> result,int start) {
        if(curr.size()==len) {
            List<Integer> temp = new ArrayList<>(curr);
            result.add(temp);
            return;
        }
        
        for(int i=start;i<nums.length;i++) {
            curr.add(nums[i]);
            combine(nums,len,curr,result,i+1);
            curr.remove(curr.size()-1);
        }
    }
}