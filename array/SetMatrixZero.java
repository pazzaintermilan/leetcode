public class Solution {

    /*
    time: O(m*n)
    space: O(m+n)
    */
    @method1
    public void setZeroes(int[][] matrix) {
        if(matrix==null||matrix.length==0)
            return;
        int row=matrix.length;
        int col=matrix[0].length;
        boolean[] rows=new boolean[row];
        boolean[] cols=new boolean[col];
       
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                if(matrix[i][j]==0){
                    rows[i]=true;
                    cols[j]=true;
                }
       
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(rows[i]==true||cols[j]==true){
                    matrix[i][j]=0;
                }
            }
        }
    }

    /*
    time: O(m*n)
    space: O(1)
    */
    @method2
    public void setZeroes(int[][] matrix) {
        if(matrix==null||matrix.length==0)
            return;
        int row=matrix.length;
        int col=matrix[0].length;
        boolean hasZeroInFirstRow=false;
        for(int j=0;j<col;j++){
            if(matrix[0][j]==0){
                hasZeroInFirstRow=true;
                break;
            }
        }
       
        for(int i=1;i<row;i++){
            boolean hasZero=false;
            for(int j=0;j<col;j++)
                if(matrix[i][j]==0){
                    hasZero=true;
                    matrix[0][j]=0;
                }
            if(hasZero)
                for(int j=0;j<col;matrix[i][j++]=0);
        }
       
        for(int j=0;j<col;j++)
            if(matrix[0][j]==0)
                for(int i=1;i<row;matrix[i++][j]=0);
       
        if(hasZeroInFirstRow)
            for(int j=0;j<col;matrix[0][j++]=0);
    }
}