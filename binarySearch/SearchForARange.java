public class Solution {
    /*
    time: O(logn)
    space: O(logn)
    */
    @method1
    public int[] searchRange(int[] nums, int target) {
        int[] ret=new int[2];
        ret[0]=findLeftPos(nums,0,nums.length-1,target,true);
        ret[1]=findLeftPos(nums,0,nums.length-1,target,false);
        return ret;
    }
    
    public int findLeftPos(int[] nums, int left, int right, int target, boolean isLeft){
        if(left>right)
            return -1;
        int mid=(left+right)/2;
        if(nums[mid]==target){
            int pos=isLeft?findLeftPos(nums,left,mid-1,target,isLeft):findLeftPos(nums,mid+1,right,target,isLeft);
            return pos==-1?mid:pos;
        }else if(nums[mid]>target)
            return findLeftPos(nums,left,mid-1,target,isLeft);
        else
            return findLeftPos(nums,mid+1,right,target,isLeft);
    }

    /*
    time: O(logn)
    space: O(1)
    */
    @method2
    public int[] searchRange(int[] nums, int target) {
        int[] ret = {-1, -1};
        // the first binary search to find the left boundary
        int l = 0, r = nums.length-1;
        while(l < r) {
            int mid = (l+r)/2;
            if (nums[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }
        // if target can not be found, return {-1, -1}
        if (nums[l] != target)
            return ret;
        ret[0] = l;
        // second binary search to find the right boundary
        r = nums.length-1;
        while(l < r) {
            // mid is calculated differently
            int mid = (l + r + 1)/2;
            if (nums[mid] > target)
                r = mid - 1;
            else
                l = mid;
        }
        ret[1] = l;
        return ret;
    }
}