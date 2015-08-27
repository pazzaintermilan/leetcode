public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        combine(ret,list,n,k,0);
        return ret;
    }
    
    private void combine(List<List<Integer>> ret,List<Integer> list,int n,int k,int pos){
        if(list.size()==k){
            List<Integer> tmp=new ArrayList<Integer>(list);
            ret.add(tmp);
            return;
        }else{
            for(int i=pos;i<n;i++){
                list.add(i+1);
                combine(ret,list,n,k,i+1);
                list.remove(list.size()-1);
            }
        }
    }
}