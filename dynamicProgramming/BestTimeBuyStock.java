public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;
        int minPrice=prices[0];
        int ret=0;
        for(int i=1;i<prices.length;i++){
            minPrice=Math.min(minPrice,prices[i]);
            ret=Math.max(ret,prices[i]-minPrice);
        }
        return ret;
    }
}