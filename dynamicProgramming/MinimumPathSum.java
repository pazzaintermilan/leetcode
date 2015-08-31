public class Solution {
    /*
    time:O(m*n)
    space:O(1)
    */
    public int minPathSum(int[][] grid) {
        int row=grid.length;
        if(row==0)
            return 0;
        int col=grid[0].length;
        int[][] matrix=grid;
        for(int i=1;i<row;i++)
            matrix[i][0]+=matrix[i-1][0];
        for(int i=1;i<col;i++)
            matrix[0][i]+=matrix[0][i-1];
        for(int i=1;i<row;i++)
            for(int j=1;j<col;j++)
                matrix[i][j]+=Math.min(matrix[i-1][j],matrix[i][j-1]);
        return matrix[row-1][col-1];
    }
}