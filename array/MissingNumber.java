public class Solution {
    /*
    time:O(n)
    space:O(1)
    */
    @method1
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int sum=0,total=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            total+=i;
        }
        total+=n;
        return total-sum;
    }

    /*
    n^n=0, n^0=n
    time:O(n)
    space:O(1)
    */
    @method2
    public int missingNumber(int[] nums) {
        int result=0;
        for(int i=1;i<=nums.length;i++) {
            result^=nums[i-1];
            result^=i;
        }
        return result;
    }
}