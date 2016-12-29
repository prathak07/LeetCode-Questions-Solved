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
        if(s==null || s.length()==0) {
            return true;
        }
        s = s.trim();
        int i=0, j=s.length()-1;
        
        while(i<j) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            
            if(!isValid(c1)) {
                i++;
                continue;
            }
            if(!isValid(c2)) {
                j--;
                continue;
            }
            
            if(!isSame(c1,c2)) {
                return false;
            }
            else {
                i++;
                j--;
            }
        }
        
        return true;
    }
    
    private boolean isValid(char c) {
        if( c>='a' && c<='z' || c>='A' && c<='Z' || c>='0' && c<='9') {
            return true;
        }
        return false;
    }
    
    private boolean isSame(char c1,char c2) {
        if( (c1>='0' && c1<='9') || (c2>='0' && c2<='9') ) {
            return c1==c2;
        }
        else {
            return ( c1==c2 || Math.abs(c1-c2)=='a'-'A' );
        }
    }
    
    /*    
        s = s.replaceAll("[^a-zA-Z0-9]+"," ");
        s = s.replaceAll(" ","");
        s = s.toLowerCase();
        
        String res = new StringBuilder(s).reverse().toString();
        return res.equals(s);
    }
    */
}