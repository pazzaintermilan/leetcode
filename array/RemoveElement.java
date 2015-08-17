public class Solution {
    /*
    time: O(n)
    space: O(1)
    */
    public int removeElement(int[] nums, int val) {
        if(nums==null||nums.length==0)
            return 0;
        int len=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val)
                nums[len++]=nums[i];
        }
        return len;
    }
}