/*
Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 231).

Example 1:

Input:
3

Output:
3
Example 2:

Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
*/
public class Solution {
    public int findNthDigit(int n) {
        int k = 1;
        long base = 1;
        
        //find the corresponding k-digit array
        while(n>base*9*k) {
            n -= base*9*k;
            k += 1;
            base *= 10;
        }
        
        //corresponding integer in the array
        long value = base + (n-1)/k;
        
        //digit of the integer
        return Long.toString(value).charAt((n-1)%k) -'0';
    }
}

/*
k: number of digits of an integer. E.g, k = 1 for 1,2,3,4,... k = 2 for 10, 11, 12...
so we have k-digits arrays like:
k = 1: 1, 2, 3, 4, 5
k = 2: 10, 11, 12, ...
base: start integer of a k-digits array. E.g base = 1 when k=1, base = 10 when k = 2...
The strategy is to find the k-digits array and then find out the corresponding integer and the digit inside the integer
*/