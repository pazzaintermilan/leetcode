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
}