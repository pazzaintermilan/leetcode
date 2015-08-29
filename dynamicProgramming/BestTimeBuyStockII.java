public class Solution {
    public int maxProfit(int[] prices) {
        int max=0;
        int i=0;
        int length=prices.length;
        while(i<length){
            while(i+1!=length&&prices[i+1]<=prices[i])
                i++;
            int j=i+1;
            if(j<length){
                while(j+1!=length&&prices[j+1]>prices[j])
                    j++;
                max=max+prices[j]-prices[i];
                i=j+1;
            }
            if(j==length){
                return max;
            }
        }
        return max;
    }
}