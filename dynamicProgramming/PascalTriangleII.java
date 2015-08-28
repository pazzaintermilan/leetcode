public class Solution {
    /*
    time: O(n^2)
    space: O(n)
    */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre=new ArrayList<Integer>();
        for(int i=0;i<=rowIndex;i++){
            List<Integer> tmp=new ArrayList<Integer>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i)
                    tmp.add(1);
                else
                    tmp.add(pre.get(j-1)+pre.get(j));
            }
            pre=tmp;
        }
        return pre;
    }
}