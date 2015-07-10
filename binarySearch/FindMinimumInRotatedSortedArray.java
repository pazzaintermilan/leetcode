public class Solution {
    /*
    time: log(n)
    space: C
    */
    public int findMin(int[] nums) {
        if(nums==null||nums.length==0)
            return -1;
        int left=0;
        int right=nums.length-1;
        while(left<right) {
            if(nums[left]<nums[right])
                return nums[left];
            int mid=(left+right)/2;
            if(nums[left]>nums[mid])
                right=mid;
            else
                left=mid+1;
        }
        return nums[left];
    }
}