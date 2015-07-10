public class Solution {
    /*
    time: O(n)
    space: O(1)
    */
    public int removeDuplicates(int[] nums) {
        if(nums==null)
            return 0;
        int len=nums.length;
        if(len==0||len==1)
            return len;
        int start=0, cur=0;
        while(cur<len){
            nums[start]=nums[cur];
            if(cur+1<len&&nums[cur+1]==nums[cur]){
                nums[start+1]=nums[cur+1];
                start+=2;
                cur+=2;
            }else{
                start++;
                cur++;
            }
            while(cur<len&&nums[cur-1]==nums[cur])
                cur++;
        }
        return start;
    }
}