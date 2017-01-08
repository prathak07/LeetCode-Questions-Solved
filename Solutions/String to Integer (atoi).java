/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
*/
public class Solution {
    public int myAtoi(String str) {
        if(str==null || str.length()==0) {
            return 0;
        }
        str = str.trim();
        long result = 0;
        boolean once = true;
        int sign = 1;
        for(int i=0;i<str.length();) {
            if(str.charAt(i)=='+' || str.charAt(i)=='-') {
                if(!once) {
                    return 0;
                }
                sign = str.charAt(i++)=='-' ? -1 : 1;
                once = false;
            }
            while(i<str.length() && str.charAt(i)>='0' && str.charAt(i)<='9') {
                result = result*10 + (str.charAt(i++)-'0');
                if(result*sign<=Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                if(result*sign>=Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            }
            return (int)result*sign;
        }
        return (int)result*sign;
    }
}