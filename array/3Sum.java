public class Solution {
    /*
    time: O(n^2)
    space: O(1) 
    */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1])
                continue;
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                if(j>i+1&&nums[j]==nums[j-1]){
                    j++;
                    continue;
                }
                if(k<nums.length-1&&nums[k]==nums[k+1]){
                    k--;
                    continue;
                }
                int sum=nums[i]+nums[j]+nums[k];
                if(sum<0)
                    j=j+1;
                else if(sum>0)
                    k=k-1;
                else{
                    List<Integer> list=new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ret.add(list);
                    j++;
                    k--;
                }
            }
        }
        return ret;
    }
}