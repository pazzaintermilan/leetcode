public class Solution {
    /*
    time: O(n)
    space: O(1)
    */
    public int firstMissingPositive(int[] A) {
        int i,j;
        int n=A.length;
        for(i=0;i<n;i++){
            int cur=A[i];
            if(cur==i+1||cur<=0||cur>n)
                continue;
            swap(A,i,cur-1);
            // if not the same, then reprocess it.
            if(A[i]!=A[cur-1])
                i--;
        }
        for(i=0;i<n;i++)
            if(A[i]!=i+1)
                return i+1;
        return n+1;
    }
   
    public void swap(int[] num, int p, int q){
        int tmp=num[p];
        num[p]=num[q];
        num[q]=tmp;
    }
}