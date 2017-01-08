/*
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
*/
public class Solution {
    public String reverseString(String s) {
        int start = 0;
        int end = s.length()-1;
        char[] arr = s.toCharArray();
        while(start<end) {
            char c = arr[start];
            arr[start] = arr[end];
            arr[end] = c;
            start++;
            end--;
        }
        return String.valueOf(arr);
    }
}