public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ret=new int[n][n];
        int val=1;
        int start=0,end=n-1;
        while(start<end){
            for(int i=start;i<end;i++)
                ret[start][i]=val++;
            for(int i=start;i<end;i++)
                ret[i][end]=val++;
            for(int i=end;i>start;i--)
                ret[end][i]=val++;
            for(int i=end;i>start;i--)
                ret[i][start]=val++;
            start++;
            end--;
        }
        if(start==end)
            ret[start][start]=val;
        return ret;
    }
}