public class Solution {
    /*
    time: O(n^2)
    space: O(n)
    */
    @method1
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null||triangle.size()==0)
            return 0;
        int maxLength=triangle.get(triangle.size()-1).size();
        int[] path=new int[maxLength];
        path[0]=triangle.get(0).get(0);
        for(int i=1;i<triangle.size();i++){
            for(int j=triangle.get(i).size()-1;j>=0;j--){
                if(j==0)
                    path[j]=path[j]+triangle.get(i).get(j);
                else if(j==triangle.get(i).size()-1)
                    path[j]=path[j-1]+triangle.get(i).get(j);
                else
                    path[j]=Math.min(path[j-1],path[j])+triangle.get(i).get(j);
            }
        }
        int min=path[0];
        for(int i=1;i<maxLength;i++)
            min=Math.min(min,path[i]);
        return min;
    }

    /*
    time: O(n^2)
    space: O(1)
    */
    @method2
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i=triangle.size()-2;i>=0;i--)
            for(int j=0;j<=i;j++)
                triangle.get(i).set(j,triangle.get(i).get(j)
                    +Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
        return triangle.get(0).get(0);
    }
}