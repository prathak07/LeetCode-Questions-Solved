/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

You should return [1,2,3,6,9,8,7,4,5].
*/
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        if(rows==0) {
            return result;
        }
        int cols = matrix[0].length;
        
        int top = 0;
        int bottom = rows-1;
        int left = 0;
        int right = cols-1;
        int dir = 0;
        
        while(top<=bottom && left<=right) {
            if(dir==0) {
                for(int i=left;i<=right;i++) {
                    result.add(matrix[top][i]);
                }
                top++;
                dir++;
            }
            else if(dir==1) {
                for(int i=top;i<=bottom;i++) {
                    result.add(matrix[i][right]);
                }
                right--;
                dir++;
            }
            else if(dir==2) {
                for(int i=right;i>=left;i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
                dir++;
            }
            else if(dir==3) {
                for(int i=bottom;i>=top;i--) {
                    result.add(matrix[i][left]);
                }
                left++;
                dir++;
            }
            dir %= 4;
        }
        
        return result;
    }
}