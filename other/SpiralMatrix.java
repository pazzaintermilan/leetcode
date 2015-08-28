public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret=new ArrayList<Integer>();
        int row=matrix.length;
        if(row==0)
            return ret;
        int col=matrix[0].length;
        int[][] step={{0,1},{1,0},{0,-1},{-1,0}};
        int x=0,y=0,dir=0;
        boolean[][] visited=new boolean[row][col];
        for(int i=0;i<row*col;i++){
            ret.add(matrix[x][y]);
            visited[x][y]=true;
            if(x+step[dir][0]==row||x+step[dir][0]<0
            ||y+step[dir][1]==col||y+step[dir][1]<0
            ||visited[x+step[dir][0]][y+step[dir][1]])
                dir=dir==3?0:dir+1;
            x+=step[dir][0];
            y+=step[dir][1];
        }
        return ret;
    }
}