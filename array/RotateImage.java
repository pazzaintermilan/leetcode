public class Solution {
    /*
    time: O(n^2)
    space: O(1)
    */
    public void rotate(int[][] matrix) {
        if(matrix==null||matrix.length==0)
            return;
        int row=matrix.length;
        for(int layer=0;layer<row/2;layer++){
            int first=layer;
            int last=row-1-layer;
            for(int i=first;i<last;i++){
                int offset=i-first;
                //save top
                int top=matrix[first][i];
                //left->top
                matrix[first][i]=matrix[last-offset][first];
                //bottom->left
                matrix[last-offset][first]=matrix[last][last-offset];
                //right->bottom
                matrix[last][last-offset]=matrix[i][last];
                //top->right
                matrix[i][last]=top;
            }
        }
    }
}