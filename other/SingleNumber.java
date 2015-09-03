public class Solution {
    public int singleNumber(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int ret=nums[0];
        for(int i=1;i<nums.length;i++)
            ret=ret^nums[i];
        return ret;
    }
}