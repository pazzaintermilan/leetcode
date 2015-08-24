public class Solution {
    /*
    time: O(logn)
    space: O(1)
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
            else if(nums[left]<nums[mid])
                left=mid+1;
            else { 
                if(nums[left]==nums[right]){
                    left++;
                    right--;
                }else 
                    left=mid+1;
            }
        }
        return nums[left];
    }
}