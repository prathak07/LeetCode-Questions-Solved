/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/
public class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) {
            return s;
        }
        
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++) {
            sb[i] = new StringBuilder();
        }
        
        boolean down = true;
        int row=0;
        for(int i=0;i<s.length();i++) {
            sb[row].append(s.charAt(i));
            if(row==0) {
                down=true;
            }
            if(row==numRows-1) {
                down=false;
            }
            row = down ? row+1 : row-1;
        }
        
        StringBuilder res = new StringBuilder();
        for(int i=0;i<numRows;i++) {
            res.append(sb[i]);
        }
        
        return res.toString();
    }
}