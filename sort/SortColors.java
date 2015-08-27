public class Solution {
	/*
	time: O(n)
	space: O(1)
	*/
	@method1
	public void sortColors(int[] nums) {
        int r=0,w=0,b=0;
        for(int i=0;i<nums.length;i++){
            r=nums[i]==0?r+1:r;
            w=nums[i]==1?w+1:w;
            b=nums[i]==2?b+1:b;
        }
        for(int i=0;i<nums.length;i++){
            if(i<r)
                nums[i]=0;
            else if(i>=r&&i<r+w)
                nums[i]=1;
            else
                nums[i]=2;
        }
    }

	/*
	time: O(n)
	space: O(1)
	*/
	@method2
    public void sortColors(int[] nums) {
        if(nums==null||nums.length==0)
            return;
        int cur=0;
        int start=0,end=nums.length-1;
        while(cur<=end){
            if(nums[cur]==0)
                swap(nums,start++,cur);
            else if(nums[cur]==2)
                swap(nums,cur,end--);
            else
                cur++;
            cur=Math.max(start,cur);
        }
    }

    private void swap(int[] nums,int p,int q){
        int tmp=nums[p];
        nums[p]=nums[q];
        nums[q]=tmp;
    }
}