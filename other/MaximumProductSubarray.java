public class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int max=nums[0];
        int min=nums[0];
        int ret=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>0){
                max=Math.max(max*nums[i],nums[i]);
                min=min*nums[i];
            }else if(nums[i]<0){
                int tmp=max;
                max=min*nums[i];
                min=Math.min(nums[i],tmp*nums[i]);
            }else{
                max=0;
                min=0;
            }
            ret=Math.max(ret,max);
        }
        return ret;
    }
}