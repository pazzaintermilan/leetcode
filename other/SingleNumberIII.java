public class Solution {
    /*
    time:O(n)
    space:O(n)
    */
    @method1
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> set=new HashSet<Integer>();
        for(int val:nums){
            if(set.contains(val))
                set.remove(val);
            else
                set.add(val);
        }
        int[] ret=new int[2];
        int idx=0;
        for(int val:set)
            ret[idx++]=val;
        return ret;
    }

    /*
    time:O(n)
    space:O(1)
    */
    @method2
    public int[] singleNumber(int[] nums) {
        // Pass 1 : 
        // Get the XOR of the two numbers we need to find
        int diff=0;
        for(int num:nums)
            diff^=num;
        // Get its last set bit
        diff&=-diff;
        // Pass 2 :
        int[] ret=new int[2]; 
        for(int num:nums){
            if((num&diff)==0) // the bit is not set
                ret[0]^=num;
            else // the bit is set
                ret[1]^=num;
        }
        return ret;
    }
}