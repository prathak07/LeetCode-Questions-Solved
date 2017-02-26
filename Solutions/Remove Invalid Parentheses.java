/*
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]

*/

public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>(); // result
        
        Queue<String> q = new LinkedList<>(); // for BFS
        Set<String> visited = new HashSet<>(); // to mark visited Strings
        
        q.offer(s);
        visited.add(s);
        
        boolean found = false; // flag to keep track we have found valid parentheses at some level so no need to add more strings
        
        while(!q.isEmpty()) {
            String str = q.poll();
            
            if(validParentheses(str)) {
                res.add(str);
                found = true;
            }
            
            // if the parentheses is already found then continue to remaining entries left in queue and don't create another level of entries for the queue
            if(found) { 
                continue;
            }
            
            // this loop creates successive strings with less parentheses thus creating levels for BFS
            for(int i=0;i<str.length();i++) {
                if( str.charAt(i)!='(' && str.charAt(i)!=')' ) {
                    continue;
                }
                
                String t = str.substring(0,i) + str.substring(i+1); // to remove character at i from string
                
                if(!visited.contains(t)) {
                    q.offer(t);
                    visited.add(t);
                }
            }
        }
        
        return res;
    }
    
    private boolean validParentheses(String s) {
        char[] arr = new char[s.length()];
        int top = -1;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='(') {
                arr[++top] = '(';
            }
            else if (s.charAt(i)==')') {
                if(top==-1) {
                    return false;
                }
                else if(arr[top]!='(') {
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