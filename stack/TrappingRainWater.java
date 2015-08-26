public class Solution {
    /*
    time: O(n)
<<<<<<< HEAD
    space: O(1)
=======
    space: O(C)
>>>>>>> feature
    */
    @method1
    public int trap(int[] height) {
        if(height==null||height.length==0)
            return 0;
        int ret=0;
        int len=height.length;
        int max=0;
        for(int i=1;i<len;i++){
            if(height[i]>height[max])
                max=i;
        }
        int leftMax=0;
        for(int i=1;i<max;i++){
            if(height[i]<height[leftMax])
                ret+=height[leftMax]-height[i];
            else
                leftMax=i;
        }
        int rightMax=len-1;
        for(int i=rightMax-1;i>max;i--){
            if(height[i]<height[rightMax])
                ret+=height[rightMax]-height[i];
            else
                rightMax=i;
        }
        return ret;
    }

    /*
    time: O(n)
<<<<<<< HEAD
    space: O(1)
=======
    space: O(C)
>>>>>>> feature
    */
    @method2
    public int trap(int[] height) {
        int n = height.length, l = 0, r = n - 1, water = 0, minHeight = 0;
        while (l < r) {
            while (l < r && height[l] <= minHeight)
                water += minHeight - height[l++];
            while (r > l && height[r] <= minHeight)
                water += minHeight - height[r--];
            minHeight = Math.min(height[l], height[r]);
        }
        return water;
    }
}