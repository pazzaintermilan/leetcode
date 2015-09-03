public class Solution {
    /*
    use hashmap
    time: O(n)
    space: O(n)
    */
    @method1
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(i-map.get(nums[i])<=k)
                    return true;
                else 
                    map.put(nums[i],i);
            }else
                map.put(nums[i],i);
        }
        return false;
    }

    /*
    use hashset
    time: O(n)
    space: O(n)
    */
    @method2
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(i>k)
                set.remove(nums[i-k-1]);
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }
        return false;
    }
}