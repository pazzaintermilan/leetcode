public class Solution {
    public boolean canJump(int[] nums) {
        int len=nums.length;
        if(nums==null||len==0)
            return false;
        int step=nums[0];
        for(int i=1;i<len;i++){
            if(step>0){
                step--;
                step=Math.max(nums[i],step);
            }else
                return false;
        }
        return true;
    }
}