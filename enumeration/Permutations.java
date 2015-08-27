public class Solution {
    /*
    recursive
    time: O(n!)
    space: O(n!)
    */
    @method1
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret=new ArrayList<List<Integer>>();
        if(nums==null||nums.length==0){
            List<Integer> list=new ArrayList<Integer>();
            ret.add(list);
            return ret;
        }
        permute(nums,0,ret);
        return ret;
    }
    
    private void permute(int[] nums,int pos,List<List<Integer>> ret){
        if(pos==nums.length){
            List<Integer> list=new ArrayList<Integer>();
            for(int i=0;i<nums.length;i++)
                list.add(nums[i]);
            ret.add(list);
            return;
        }else{
            for(int i=pos;i<nums.length;i++){
                swap(nums,pos,i);
                permute(nums,pos+1,ret);
                swap(nums,pos,i);
            }
        }
    }
    
    private void swap(int[] nums,int p,int q){
        int tmp=nums[p];
        nums[p]=nums[q];
        nums[q]=tmp;
    }

    /*
    iterative
    time: 
    space:
    */
    @method2
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> res=new LinkedList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for(int n:nums){
            int size=res.size();
            for(;size>0;size--){
                List<Integer> r=res.pollFirst();
                for(int i=0;i<=r.size();i++) {
                    List<Integer> t=new ArrayList<Integer>(r);
                    t.add(i,n);
                    res.add(t);
                }
            }
        }
        return res;
    }
}