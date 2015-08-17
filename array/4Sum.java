public class Solution {
    /*
    time: O(n^3)
    space: O(1)
    */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1])
                continue;     
            for(int j=i+1;j<nums.length;j++){
                if(j>i+1&&nums[j]==nums[j-1])
                    continue;
                int p=j+1;
                int q=nums.length-1;
                while(p<q){
                    if(p>j+1&&nums[p]==nums[p-1]){
                        p++;
                        continue;
                    }
                    if(q<nums.length-1&&nums[q]==nums[q+1]){
                        q--;
                        continue;
                    }
                    int sum=nums[i]+nums[j]+nums[p]+nums[q];
                    if(sum<target)
                        p++;
                    else if(sum>target)
                        q--;
                    else{     
                        List<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[p]);
                        tmp.add(nums[q]);
                        ret.add(tmp);
                        p++;
                    }
                }
            }
        }
        return ret;
    }
}