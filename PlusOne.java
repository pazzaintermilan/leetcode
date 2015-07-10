public class Solution {
    /*
    time: O(n)
    space: O(n)
    */
    public int[] plusOne(int[] digits) {
        int carry=1;
        for(int i=digits.length-1;i>=0;i--){
            int sum=digits[i]+carry;
            digits[i]=sum%10;
            carry=sum/10;
        }
        if(carry==0)
            return digits;
        else{
            int[] newDigits=new int[digits.length+1];
            for(int i=1;i<=digits.length;i++)
                newDigits[i]=digits[i-1];
            newDigits[0]=1;
            return newDigits;
        }
    }
}