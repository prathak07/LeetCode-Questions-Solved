/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/
public class Solution {
    public boolean isValid(String s) {
        char[] arr = new char[s.length()];
        int top = -1;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{') {
                arr[++top] = s.charAt(i);
            }
            else if (s.charAt(i)==')' || s.charAt(i)==']' || s.charAt(i)=='}') {
                if(top==-1) {
                    return false;
                }
                else if(s.charAt(i)==')' && arr[top]!='(') {
                    return false;
                }
                else if(s.charAt(i)=='}' && arr[top]!='{') {
                    return false;
                }
                else if(s.charAt(i)==']' && arr[top]!='[') {
                    return false;
                }
                else {
                    top--;
                }
            }
        }
        
        return top==-1 ? true : false;
    }
}