public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret=new ArrayList<List<String>>();
        int[] queen=new int[n];
        dfs(ret,queen,n,0);
        return ret;
    }
    
    private void dfs(List<List<String>> ret,int[] queen,int n,int row){
        if(row==n){
            List<String> list=new ArrayList<String>();
            for(int i=0;i<n;i++){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<n;j++){
                    if(queen[i]!=j)
                        sb.append(".");
                    else
                        sb.append("Q");
                }
                String str=String.valueOf(sb);
                list.add(str);
            }
            ret.add(list);
            return;
        }
        for(int col=0;col<n;col++){
            queen[row]=col;
            if(isSafe(queen,row,col))
                dfs(ret,queen,n,row+1);
        }
    }
    
    private boolean isSafe(int[] queen,int row,int col){
        for(int preRow=0;preRow<row;preRow++){
            int diff=Math.abs(queen[row]-queen[preRow]);
            if(diff==0||diff==row-preRow)
                return false;
        }
        return true;
    }
}