public class Solution {
    /*
    time: O(n)
    space: O(n)
    */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        int[] result=new int[2];
        int len=nums.length; 
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[1]=i+1;
                result[0]=map.get(target-nums[i])+1;
                return result;
            }else
                map.put(nums[i],i);
        }
        return null;
    }
}