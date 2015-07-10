public class Solution {
    /*
    time: O(n) n is the number of digits
    space: O(1)
    */
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int base=1;
        while(x/base>=10)
            base*=10;
        while(x>0){
            int leftDigit = x/base;
            int rightDigit = x%10;
            if(leftDigit!=rightDigit)
                return false;
            x=x-leftDigit*base;
            x=x/10;
            base=base/100;
        }
        return true;
    }
}