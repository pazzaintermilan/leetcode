public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] ret=new int[m][n];
        if(obstacleGrid[0][0]==1)
            return 0;
        ret[0][0]=1;
        for(int i=1;i<m;i++){
            if(obstacleGrid[i][0]==0)
                ret[i][0]=ret[i-1][0];
            else
                ret[i][0]=0;
        }
        for(int i=1;i<n;i++){
            if(obstacleGrid[0][i]==0)
                ret[0][i]=ret[0][i-1];
            else
                ret[0][i]=0;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1)
                    ret[i][j]=0;
                else
                    ret[i][j]=ret[i-1][j]+ret[i][j-1];
            }
        }
        return ret[m-1][n-1];
    }
}