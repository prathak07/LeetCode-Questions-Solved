/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".
*/
public class Solution {
    public String reverseVowels(String s) {
        if(s==null || s.length()==0) {
            return s;
        }
        
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('o');
        set.add('O');
        set.add('u');
        set.add('U');
        
        int start = 0;
        int end = s.length()-1;
        char[] word = s.toCharArray();
        while(start<end) {
            while(start<end && !set.contains(word[start])) {
                start++;
            }
            while(start<end && !set.contains(word[end])) {
                end--;
            }
            
            char temp = word[start];
            word[start] = word[end];
            word[end] = temp;
            
            start++;
            end--;
        }
        
        return new String(word);
    }
    /*
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('o');
        set.add('O');
        set.add('u');
        set.add('U');
        
        Stack<Character> vow = new Stack<>();
        
        for(int i=0;i<s.length();i++) {
            if(set.contains(s.charAt(i))) {
                vow.push(s.charAt(i));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            if(set.contains(s.charAt(i))) {
                sb.append(vow.pop());
            }
            else {
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
    */
}