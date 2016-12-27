/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

public class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]+"," ");
        s = s.replaceAll(" ","");
        s = s.toLowerCase();
        
        String res = new StringBuilder(s).reverse().toString();
        if(res.equals(s)) {
            return true;
        }
        else {
            return false;
        }
    }
}