public class Solution {
    /*
    time: O(n^2)
    space: O(1)
    */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        boolean first=false;
        int ret=0;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                sum=nums[i]+nums[j]+nums[k];
                if(first==false){
                    ret=sum;
                    first=true;
                }else{
                    if(Math.abs(sum-target)<Math.abs(ret-target))
                        ret=sum;
                }
                if(sum==target)
                    return sum;
                if(sum>target)
                    k--;
                else
                    j++;
            }
        }
        return ret;
    }
}