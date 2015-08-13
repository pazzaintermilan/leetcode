public class Solution {
    /*
    time: O(n^2)
    space: O(n)
    */
    public int numTrees(int n) {
        if(n==0||n==1)
            return 1;
        int[] ret=new int[n+1];
        ret[0]=1;
        ret[1]=1;
        ret[2]=2;
        for(int i=3;i<=n;i++){
            int tmp=0;
            for(int j=0;j<i;j++){
                tmp+=ret[j]*ret[i-j-1];
            }
            ret[i]=tmp;
        }
        return ret[n];
    }
}