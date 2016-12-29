/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons).

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/
public class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Integer,String> map = new HashMap<>();
        map.put(0,"");
        map.put(1,"");
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        
        List<String> result = new ArrayList<>();
        if(digits==null || digits.length()==0) {
            return result;
        }
        
        List<Character> temp = new ArrayList<>();
        getStrings(digits,temp,result,map);
        return result;
    }
    
    private void getStrings(String digits,List<Character> temp,List<String> result,Map<Integer,String> map) {
        if(digits.length()==0) {
            char[] ch = new char[temp.size()];
            for(int i=0;i<temp.size();i++) {
                ch[i] = temp.get(i);
            }
            result.add(String.valueOf(ch));
            return;
        }
        
        Integer dig = Integer.parseInt(digits.substring(0,1));
        String letters = map.get(dig);
        
        for(int i=0;i<letters.length();i++) {
            temp.add(letters.charAt(i));
            getStrings(digits.substring(1),temp,result,map);
            temp.remove(temp.size()-1);
        }
    }
}