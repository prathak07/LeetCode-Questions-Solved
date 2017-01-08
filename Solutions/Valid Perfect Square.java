/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True

Example 2:

Input: 14
Returns: False
*/
public class Solution {
    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;
        while(low<=high) {
            long mid = low + (high-low)/2;
            if(mid*mid==num) {
                return true;
            }
            else if(mid*mid<num) {
                low = (int)mid+1;
            }
            else {
                high = (int)mid-1;
            }
        }
        return false;
        /* This is slower as we are subtrating the number to reach 0
        int i=1;
        while(num>0) {
            num -= i;
            i += 2;
        }
        return num==0;
        */
    }
}