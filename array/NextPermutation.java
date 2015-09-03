public class Solution {
    /*
    time: O(n)
    space: O(1)
    */
    public void nextPermutation(int[] nums) {
        if(nums==null||nums.length==0||nums.length==1)
            return;
        int len=nums.length;
        int cur=len-1;
        int pos=-1;
        while(cur>0&&nums[cur]<=nums[cur-1])
            cur--;
        pos=cur-1;
        if(pos<0){
            reverse(nums,0,len-1);
        }else{
            cur=len-1;
            while(nums[cur]<=nums[pos])
                cur--;
            swap(nums,cur,pos);
            reverse(nums,pos+1,len-1);
        }
    }
    
    private void swap(int[] num,int p,int q){
        int tmp=num[p];
        num[p]=num[q];
        num[q]=tmp;
    }
    
    private void reverse(int[] num, int start, int end){
        while(start<end)
            swap(num,start++,end--);
    }
}