/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) {
            return 0;
        }
        int[] map = new int[256];
        int count=0,start=0,end=0,res=0;
        while(end<s.length()) {
            if(map[s.charAt(end++)]++>0) {
                count++;
            }
            // System.out.println(count);
            // display(map);
            while(count>0) {
                if(map[s.charAt(start++)]-->1) {
                    count--;
                }
            }
            // System.out.println(count);
            // display(map);
            res = Math.max(res,end-start);
            // System.out.println(res);
            // System.out.println("---------------------------------------------------------------------------------------");
        }
        return res;
    }
    // private void display(int[] arr) {
    //     for(int i=0;i<arr.length;i++) {
    //         System.out.print(arr[i]+" ");
    //     }
    //     System.out.println();
    // }
}