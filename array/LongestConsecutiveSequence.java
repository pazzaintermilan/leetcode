public class Solution {
    /*
    time: O(n)
    space: O(n)
    */
    public int longestConsecutive(int[] nums) {
        int ret=0;
        HashSet<Integer> set=new HashSet<Integer>();
        for(int val:nums)
            set.add(val);
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                int count=1;
                int left=nums[i]-1;
                set.remove(nums[i]);
                while(set.contains(left)){
                    count++;
                    set.remove(left);
                    left--;
                }
                int right=nums[i]+1;
                while(set.contains(right)){
                    count++;
                    set.remove(right);
                    right++;
                }
                ret=Math.max(ret,count);
            }
        }
        return ret;
    }
}