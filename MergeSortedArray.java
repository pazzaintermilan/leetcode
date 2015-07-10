public class Solution {
    /*
    考虑从后往前比较，这样就不会产生需要数据后移的问题了。时间复杂度O(n+m)
    */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index=m+n-1;
        int aIndex=m-1;
        int bIndex=n-1;
        while(aIndex>=0&&bIndex>=0){
            if(nums1[aIndex]>nums2[bIndex])
                nums1[index--]=nums1[aIndex--];
            else
                nums1[index--]=nums2[bIndex--];
        }
        while(aIndex>=0)
            nums1[index--]=nums1[aIndex--];
        while(bIndex>=0)
            nums1[index--]=nums2[bIndex--];
    }
}