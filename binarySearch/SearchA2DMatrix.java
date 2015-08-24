public class Solution {
    /*
    time: O(logn)
    space: O(1)
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0)
            return false;
        int row=matrix.length;
        int col=matrix[0].length;
        int left=0,right=row*col-1;
        while(left<=right){
            int mid=(left+right)/2;
            int i=mid/col;
            int j=mid%col;
            if(matrix[i][j]==target)
                return true;
            else if(matrix[i][j]>target)
                right=mid-1;
            else
                left=mid+1;
        }
        return false;
    }
}