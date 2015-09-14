public class Solution {
    /*
    recursive
    time: O(2^n)
    space: stack:O(n)+O(2^n)
    */
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> ret=new ArrayList<List<Integer>>();
        List<Integer> tmp=new ArrayList<Integer>();
        Arrays.sort(S);
        subset(ret,tmp,S,0);
        return ret;
    }
   
    private void subset(List<List<Integer>> ret, List<Integer> tmp, int[] num, int pos){
        if(pos==num.length){
            ret.add(new ArrayList<Integer>(tmp));
            return;
        }
        subset(ret,tmp,num,pos+1);
        tmp.add(num[pos]);
        subset(ret,tmp,num,pos+1);
        tmp.remove(tmp.size()-1);
    }

    /*
    iterative
    */
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        if(S == null || S.length == 0)
            return res;
        Arrays.sort(S);
        for(int i=0;i<S.length;i++){
            int size = res.size();
            for(int j=0;j<size;j++){
                ArrayList<Integer> tmp = new ArrayList<Integer>(res.get(j));
                tmp.add(S[i]);
                res.add(tmp);
            }
        }
        return res;
    }
}