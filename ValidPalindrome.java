public class Solution {
    /*
    time: O(n)
    space: O(1)
    */
    public boolean isPalindrome(String s) {
        if(s==null||s.length()==0)
            return true;
        int left=0,right=s.length()-1;
        while(left<right){
            char leftChar=s.charAt(left);
            while(!(leftChar>='a'&&leftChar<='z')
                &&!(leftChar>='A'&&leftChar<='Z')
                &&!(leftChar>='0'&&leftChar<='9')){
                if(left>=right)
                    return true;
                left++;
                leftChar=s.charAt(left);
            }
            char rightChar=s.charAt(right);
            while(!(rightChar>='a'&&rightChar<='z')
                &&!(rightChar>='A'&&rightChar<='Z')
                &&!(rightChar>='0'&&rightChar<='9')){
                if(left>=right)
                    return true;
                right--;
                rightChar=s.charAt(right);
            }
            leftChar=Character.toUpperCase(leftChar);
            rightChar=Character.toUpperCase(rightChar);
            if(leftChar!=rightChar)
                return false;
            left++;
            right--;
        }
        return true;
    }
}