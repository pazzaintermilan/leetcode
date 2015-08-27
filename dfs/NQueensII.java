public class Solution {
    public int totalNQueens(int n) {
        int[] queen=new int[n];
        int[] ret=new int[1];
        dfs(queen,ret,n,0);
        return ret[0];
    }
    
    private void dfs(int[] queen,int[] ret,int n,int row){
        if(row==n){
            ret[0]++;
            return;
        }
        for(int col=0;col<n;col++){
            queen[row]=col;
            if(isSafe(queen,row,col))
                dfs(queen,ret,n,row+1);
        }
    }
    
    private boolean isSafe(int[] queen,int row,int col){
        for(int preRow=0;preRow<row;preRow++){
            int diff=Math.abs(queen[preRow]-queen[row]);
            if(diff==0||diff==row-preRow)
                return false;
        }
        return true;
    } 
}