/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Clarification:
    What constitutes a word?
    
        A sequence of non-space characters constitutes a word.
        Could the input string contain leading or trailing spaces?
        Yes. However, your reversed string should not contain leading or trailing spaces.
        How about multiple spaces between two words?
        Reduce them to a single space in the reversed string.
*/
public class Solution {
    public String reverseWords(String s) {
        if(s==null || s.length()==0) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        String[] strs = s.split(" ");
        for(int i=strs.length-1;i>=0;i--) {
            if(!strs[i].equals("")) {
                sb.append(strs[i]).append(" ");
            }
        }
        
        return strs.length==0 ? "" : sb.substring(0,sb.length()-1);
    }
}