/*
Assume you have an array of length n initialized with all 0's and are given k update operations.

Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.

Return the modified array after all k operations were executed.

Example:

Given:

    length = 5,
    updates = [
        [1,  3,  2],
        [2,  4,  3],
        [0,  2, -2]
    ]

Output:

    [-2, 0, 3, 5, 3]
Explanation:

Initial state:
[ 0, 0, 0, 0, 0 ]

After applying operation [1, 3, 2]:
[ 0, 2, 2, 2, 0 ]

After applying operation [2, 4, 3]:
[ 0, 2, 5, 5, 3 ]

After applying operation [0, 2, -2]:
[-2, 0, 3, 5, 3 ]
Hint:

Thinking of using advanced data structures? You are thinking it too complicated.
For each update operation, do you really need to update all elements between i and j?
Update only the first and end element is sufficient.
The optimal time complexity is O(k + n) and uses O(1) extra space.
*/
public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        if(length<=0) {
            return null;
        }
        
        int[] arr = new int[length];
        for(int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int inc = update[2];
            //here we are trying to make illusion of range sum... start tells start of sum and end+1 tells end of it
            arr[start] += inc;
            if(end < length-1) {
                arr[end+1] -= inc;
            }
        }
        
        int sum=0;
        for(int i=0;i<length;i++) {
            sum += arr[i];
            arr[i] = sum;
        }
        
        return arr;
    }
    /*
        if(length<=0) {
            return null;
        }
        
        int[] arr = new int[length];
        for(int[] update : updates) {
            modifyArray(arr,update);
        }
        
        return arr;
    }
    
    private void modifyArray(int[] arr,int[] update) {
        for(int i=update[0];i<=update[1];i++) {
            arr[i] += update[2];
        }
    }
    */
}