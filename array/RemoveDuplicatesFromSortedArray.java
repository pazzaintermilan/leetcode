public class Solution {
    /*
    time: O(n)
    space: O(1)
    */
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int len=0;
        int pre=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=pre){
                nums[len++]=pre;
                pre=nums[i];
            }
        }
        nums[len++]=pre;
        return len;
    }
}