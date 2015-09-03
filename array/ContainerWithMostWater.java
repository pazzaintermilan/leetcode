public class Solution {
    /*
    time: O(n)
    space: O(1)
    */
    public int maxArea(int[] height) {
        int sum=0;
        int left=0,right=height.length-1;
        while(left<right){
            int h=Math.min(height[left],height[right]);
            int val=h*(right-left);
            sum=Math.max(sum,val);
            if(height[left]<height[right])
                left++;
            else
                right--;
        }
        return sum;
    }
}