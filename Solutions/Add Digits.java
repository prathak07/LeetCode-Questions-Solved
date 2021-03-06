/*
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?
*/
public class Solution {
    public int addDigits(int num) {
        return (1 + (num-1)%9); // Digital Root - google for details
    }
    /* This takes O(n) time
        num = sumDigits(num);
        while(num>9) {
            num = sumDigits(num);
        }
        return num;
    }
    public int sumDigits(int n) {
        int sum=0;
        while(n>0) {
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
    */
}

/*
For base b (decimal case b = 10), the digit root of an integer is:

dr(n) = 0 if n == 0
dr(n) = (b-1) if n != 0 and n % (b-1) == 0
dr(n) = n mod (b-1) if n % (b-1) != 0

or

dr(n) = 1 + (n - 1) % 9

Note here, when n = 0, since (n - 1) % 9 = -1, the return value is zero (correct).

From the formula, we can find that the result of this problem is immanently periodic, with period (b-1).

Output sequence for decimals (b = 10):

~input: 0 1 2 3 4 ...
output: 0 1 2 3 4 5 6 7 8 9 1 2 3 4 5 6 7 8 9 1 2 3 ....

Henceforth, we can write the following code, whose time and space complexities are both O(1).
*/