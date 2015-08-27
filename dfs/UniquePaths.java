public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] ret=new int[m][n];
        for(int i=0;i<m;i++)
            ret[i][0]=1;
        for(int j=0;j<n;j++)
            ret[0][j]=1;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                ret[i][j]=ret[i-1][j]+ret[i][j-1];
            }
        }
        return ret[m-1][n-1];
    }
}