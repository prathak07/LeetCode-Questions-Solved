/*
Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

For example, Given s = “eceba”,

T is "ece" which its length is 3.
*/
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] map = new int[128];
        int begin=0,end=0;
        int count=0;
        int max=0;
        
        while(end < s.length()) {
            if(map[s.charAt(end++)]++==0) { // increase the count if we find anything new in the string
                count++;
            }
            while(count>2) {
                if(map[s.charAt(begin++)]--==1) { // decrease the count and shrink the window
                    count--;
                }
            }
            max = Math.max(max,end-begin);
        }
        
        return max;
    }
}