/*
Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note: 
You may assume that n is always positive.
Factors should be greater than 1 and less than n.
Examples: 
input: 1
output: 
[]
input: 37
output: 
[]
input: 12
output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
input: 32
output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]
*/
public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if(n<=3) {
            return result;
        }
        
        int[] nums = new int[n/2];
        for(int i=0;i<nums.length;i++) {
            nums[i] = i+2;
        }
        
        List<Integer> curr = new ArrayList<>();
        getFactors(nums,n,curr,result,0);
        
        return result;
    }
    
    private void getFactors(int[] nums,int target,List<Integer> curr,List<List<Integer>> result,int start) {
        if(target==1) {
            List<Integer> temp = new ArrayList<>(curr);
            result.add(temp);
            return;
        }
        
        for(int i=start;i<nums.length;i++) {
            if(target%nums[i]==0) {
                curr.add(nums[i]);
                getFactors(nums,target/nums[i],curr,result,i);
                curr.remove(curr.size()-1);
            }
        }
    }
}