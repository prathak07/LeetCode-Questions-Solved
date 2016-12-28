/*
A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.


For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]

Note:

The order of output does not matter.
The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
*/
public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> watch = new ArrayList<>();
        int[] hr = {1,2,4,8};
        int[] mn = {1,2,4,8,16,32};
        for(int i=0;i<=num;i++) {
            List<Integer> hours = generateDigits(hr,i);
            List<Integer> minutes = generateDigits(mn,num-i);
            for(int hour : hours) {
                if(hour>11) {
                    continue;
                }
                for(int minute : minutes) {
                    if(minute>59) {
                        continue;
                    }
                    watch.add( hour + ":" + (minute<10 ? "0"+minute : minute) );
                }
            }
        }
        return watch;
    }
    
    private List<Integer> generateDigits(int[] nums,int count) {
        List<Integer> res = new ArrayList<>();
        helper(res,nums,count,0,0);
        return res;
    }
    
    private void helper(List<Integer> res,int[] nums,int count,int start,int sum) {
        if(count==0) {
            res.add(sum);
            return;
        }
        for(int i=start;i<nums.length;i++) {
            helper(res,nums,count-1,i+1,sum+nums[i]);
        }
    }
    /*
    public List<String> readBinaryWatch(int num) {    
        List<String> result = new ArrayList<>();
        for(int h=0;h<12;h++) {
            for(int m=0;m<60;m++) {
                if(numberOfOnes(h)+numberOfOnes(m)==num) {
                    result.add(String.format("%d:%02d",h,m));
                }
            }
        }
        return result;
    }
    private int numberOfOnes(int n) {
        int count=0;
        while(n>0) {
            if(n%2==1) {
                count++;
            }
            n/=2;
        }
        return count;
    }
    */
}