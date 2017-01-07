/*
Count the number of prime numbers less than a non-negative number, n.
*/
public class Solution {
    public int countPrimes(int n) {
        if(n<=1) {
            return 0;
        }
        boolean[] notPrimes = new boolean[n];
        notPrimes[0]=true;
        notPrimes[1]=true;
        for(int i=2;i*i<n;i++) {
            if(!notPrimes[i]) {
                for(int j=2;i*j<n;j++) {
                    notPrimes[i*j]=true;
                }
            }
        }
        int count=0;
        for(int i=2;i<n;i++) {
            if(!notPrimes[i]) {
                count++;
            }
        }
        return count;
    }
}