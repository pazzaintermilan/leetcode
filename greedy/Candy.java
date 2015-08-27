public class Solution {
    /*
    time: O(n)
    space: O(n)
    */
    public int candy(int[] ratings) {
        if(ratings==null||ratings.length==0)
            return 0;
        int len=ratings.length;
        int[] candies=new int[len];
        for(int i=0;i<len;i++)
            candies[i]=1;
        for(int i=0;i<len-1;i++){
            if(ratings[i]<ratings[i+1])
                candies[i+1]=candies[i]+1;
        }
        for(int i=len-1;i>0;i--){
            if(ratings[i]<ratings[i-1]){
                if(candies[i-1]<candies[i]+1)
                    candies[i-1]=candies[i]+1;
            }
        }
        int ret=candies[0];
        for(int i=1;i<candies.length;i++)
            ret+=candies[i];
        return ret;
    }
}