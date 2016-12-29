/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/
public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i=digits.length-1;i>=0;i--) {
            digits[i] += carry;
            carry = digits[i]/10;
            digits[i] %= 10;
        }
        if(carry==1) {
            int[] dig = new int[digits.length+1];
            dig[0] = carry;
            for(int i=0;i<digits.length;i++) {
                dig[i+1] = digits[i];
            }
            return dig;
        }
        
        return digits;
    }
}