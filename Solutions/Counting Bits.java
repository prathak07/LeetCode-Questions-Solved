/*
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
Hint:

You should make use of what you have produced already.
Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to generate new range from previous.
Or does the odd/even status of the number help you in calculating the number of 1s?
*/
public class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        
        int p = 1; // for tracking the index of x
        int pow = 1; // this is the number which is power of two
        
        for(int i=1;i<=num;i++) {
            if(i==pow) {
                result[i] = 1;
                pow <<= 1;
                p = 1;
            }
            else {
                result[i] = result[p]+1;
                p++;
            }
        }
        
        return result;
    }
    /* Very heavy method as number of 1 bits are calculated for each number
        int[] arr = new int[num+1];
        for(int i=0;i<num+1;i++) {
            arr[i] = numOfOnes(i);
        }
        return arr;
    }
    
    public int numOfOnes(int n) {
        int count=0;
        if(n==0) {
            return 0;
        }
        while(n>0) {
            if(n%2==1) {
                count++;
            }
            n = n/2;
        }
        return count;
    }
    */
}