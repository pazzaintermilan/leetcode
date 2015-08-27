public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        Arrays.sort(candidates);
        combine(ret,list,candidates,target,0);
        return ret;
    }
    
    private void combine(List<List<Integer>> ret,List<Integer> list,int[] num,int target,int pos){
        if(target==0){
            List<Integer> tmp=new ArrayList<Integer>(list);
            ret.add(tmp);
            return;
        }
        for(int i=pos;i<num.length;i++){
            if(target<num[i])
                return;
            list.add(num[i]);
            combine(ret,list,num,target-num[i],i);
            list.remove(list.size()-1);
        }
    }
}