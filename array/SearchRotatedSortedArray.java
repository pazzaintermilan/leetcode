public class Solution {
<<<<<<< HEAD
<<<<<<< HEAD
    /*
    time: O(logn)
    space: O(1)
    */
=======
>>>>>>> feature
=======
>>>>>>> feature
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0)
            return -1;
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid]>nums[right]){
                if(nums[left]<=target&&target<nums[mid])
                    right=mid-1;
                else
                    left=mid+1;
            }else{
                if(nums[mid]<target&&target<=nums[right])
                    left=mid+1;
                else
                    right=mid-1;
            }
        }
        return -1;
    }
}