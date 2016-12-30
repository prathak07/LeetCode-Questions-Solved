/*
Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
*/
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates==null || candidates.length==0) {
            return result;
        }
        
        Arrays.sort(candidates);
        List<Integer> curr = new ArrayList<>();
        
        combinationSum(candidates,target,curr,result,0);
        
        return result;
    }
    
    private void combinationSum(int[] candidates,int target,List<Integer> curr,List<List<Integer>> result,int start) {
        if(target==0) {
            List<Integer> temp = new ArrayList<>(curr);
            result.add(temp);
            return;
        }
        
        if (target<0) {
            return;
        }
        
        for(int i=start;i<candidates.length;i++) {
            curr.add(candidates[i]);
            combinationSum(candidates,target-candidates[i],curr,result,i);
            curr.remove(curr.size()-1);
        }
    }
}