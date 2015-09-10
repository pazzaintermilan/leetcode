public class Solution {
    public void solveSudoku(char[][] board) {
        dfs(board,0);
    }

    private boolean dfs(char[][] board,int pos){
        int n=board.length;
        if(pos==n*n)
            return true;
        int x=pos/n;
        int y=pos%n;
        if(board[x][y]=='.'){
            for(char c='1';c<='9';c++){
                board[x][y]=c;
                if(validate(board,x,y)&&dfs(board,pos+1))
                    return true;
                board[x][y]='.';
            }
        }
        else
            if(dfs(board,pos+1))
                return true;
        return false;
    }

    private boolean validate(char[][] board,int x,int y){
        char c=board[x][y];
        for(int i=0;i<9;i++){
            if(i!=y&&board[x][i]==c)
                return false;
            if(i!=x&&board[i][y]==c)
                return false;
        }
        int xx=x/3*3;
        int yy=y/3*3;
        for(int i=xx;i<xx+3;i++){
            for(int j=yy;j<yy+3;j++)
                if (i!=x&&j!=y&&board[i][j]==c)
                    return false;
        }
        return true;
    }
}