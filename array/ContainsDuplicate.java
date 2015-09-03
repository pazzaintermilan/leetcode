public class Solution {
    /*
    time: O(nlogn)
    space: O(1)
    */
    @method1
    public boolean containsDuplicate(int[] nums) {
        if(nums==null||nums.length<=1)
            return false;
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1])
                return true;
        }
        return false;
    }

	/*
	time: O(n)
	space: O(n)
	*/
    @method2
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }
        return false;
    }
}