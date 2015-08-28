public class Solution {
    public boolean isHappy(int n) {
        while(true){
            if(n==1)
                return true;
            n=getSumDigits(n);
            if(n==4)
                return false;
        }
    }
    
    private int getSumDigits(int val){
        int sum=0;
        while(val>0){
            int digit=val%10;
            sum+=Math.pow(digit,2);
            val=val/10;
        }
        return sum;
    }
}