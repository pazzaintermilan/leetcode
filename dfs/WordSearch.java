public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length==0)
            return false;
        int row=board.length;
        boolean[][] used=new boolean[row][];
        for(int i=0;i<board.length;i++)
            used[i]=new boolean[board[i].length];
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[i].length;j++)
                if(dfs(i,j,0,word,board,used))
                    return true;
        return false;
    }

    private boolean isInboard(int i, int j,char[][] board){
        if(i<0||i>=board.length)
            return false;
        if(j<0||j>=board[i].length)
            return false;
        return true;
    }

    private boolean dfs(int si,int sj,int n,String word,char[][] board,boolean[][] used){
        if(n==word.length())
            return true;
        if(isInboard(si,sj,board)){
            if(!used[si][sj]&&board[si][sj]==word.charAt(n)){
                used[si][sj]=true;
                boolean ret=false;
                if(dfs(si+1,sj,n+1,word,board,used))
                    ret=true;
                else if(dfs(si-1,sj,n+1,word,board,used))
                    ret=true;
                else if(dfs(si,sj+1,n+1,word,board,used))
                    ret=true;
                else if(dfs(si,sj-1,n+1,word,board,used))
                    ret=true;
                used[si][sj]=false;
                return ret;
            }
        }
        return false;
    }
}