public class Solution {
    /*
    Time limit exceeded
    */
    @method1
    public int countDigitOne(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            count+=digitOne(i);
        }
        return count;
    }
    
    public int digitOne(int val){
        int count=0;
        while(val>0){
            int digit=val%10;
            if(digit==1)
                count++;
            val=val/10;
        }
        return count;
    }

    
}