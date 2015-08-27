public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> ret=new ArrayList<List<Integer>>();
        List<Integer> tmp=new ArrayList<Integer>();
        Arrays.sort(num);
        dfs(num,ret,tmp,target,0);
        return ret;
    }
   
    public void dfs(int[] num,List<List<Integer>> ret,List<Integer> tmp,int target,int pos){
        if(target==0){
            List<Integer> list=new ArrayList<Integer>(tmp);
            ret.add(list);
            return;
        }
        for(int i=pos;i<num.length;i++){
            if(i>pos&&num[i]==num[i-1])
                continue;
            if(target<num[i])
                return;
            tmp.add(num[i]);
            dfs(num,ret,tmp,target-num[i],i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}