public class Solution {
    /*
    time: O(logn)
    space: O(1)
    */
    public int searchInsert(int[] nums, int target) {
        if(nums==null||nums.length==0)
            return -1;
        int left=0, right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
                left=mid+1;
            else
                right=mid-1;
        }
        return left;
    }
}