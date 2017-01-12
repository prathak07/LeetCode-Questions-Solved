/*
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
*/
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            int val = Math.abs(nums[i])-1;
            if(nums[val]<0) {
                res.add(val+1);
            }
            nums[val] = -nums[val];
            // display(nums);
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
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(nums[i])) {
                int val = map.get(nums[i]);
                map.put(nums[i],val+1);
            }
            else {
                map.put(nums[i],1);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue()==2) {
                result.add(entry.getKey());
            }
        }
        
        return result;
    }
    */
}