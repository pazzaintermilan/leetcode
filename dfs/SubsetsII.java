public class Solution {
    /*
    time: O(2^n)
    space: stack:O(n)+O(2^n)
    */
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> ret=new ArrayList<List<Integer>>();
        List<Integer> tmp=new ArrayList<Integer>();
        Arrays.sort(num);
        dfs(ret,tmp,num,0);
        return ret;
    }
  
    public void dfs(List<List<Integer>> ret,List<Integer> tmp,int[] num,int pos){
        ret.add(new ArrayList<Integer>(tmp));
        for(int i=pos;i<num.length;i++){
            if(i!=pos&&num[i]==num[i-1])
                continue;
            tmp.add(num[i]);
            dfs(ret,tmp,num,i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}