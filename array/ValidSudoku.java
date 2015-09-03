public class Solution {
    /*
    time: O(n^2)
    space: O(n^2)
    */
    public boolean isValidSudoku(char[][] board) {
        if(board==null||board.length==0)
            return true;
        boolean[][] row=new boolean[9][9];
        boolean[][] col=new boolean[9][9];
        boolean[][] block=new boolean[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.')
                    continue;
                int val=board[i][j]-'1';
                if(row[i][val]||col[j][val]||block[i/3*3+j/3][val])
                    return false;
                row[i][val]=col[j][val]=block[i/3*3+j/3][val]=true;
            }
        }
        return true;
    }
}