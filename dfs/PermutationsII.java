public class Solution {
    /*
    recursive
    time: O(n!)
    space: O(n!)
    */
    @method1
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> ret=new ArrayList<List<Integer>>();
        permute(num,0,ret);
        return ret;
    }
   
    public void permute(int[] num,int step,List<List<Integer>> ret) {
        if(step==num.length){
            List<Integer> list=new ArrayList<Integer>();
            for(int i=0;i<num.length;i++)
                list.add(num[i]);
            ret.add(list);
            return;
        }
        int i=0;
        for (i=step;i<num.length;i++) {
            if (noswap(num,i,step))
                continue;
            swap(num,i,step);
            permute(num,step+1,ret);
            swap(num,i,step);
        }
    }
   
    public boolean noswap(int[] num,int i,int step){
        int j=0;
        for (j=step;j<i;j++)
            if(num[i]==num[j])
                return true;
        return false;
    }
   
    public void swap(int[] num,int p,int q){
        int tmp=num[p];
        num[p]=num[q];
        num[q]=tmp;
    }
}