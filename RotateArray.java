public class Solution {
	/*
	time: O(n)
	space: O(n)
	*/
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        int [] ret=new int [n];
        for(int i=0;i<n;i++)
            ret[(i+k)%n]=nums[i];
        for(int i=0;i<n;i++)
            nums[i]=ret[i];
    }
}