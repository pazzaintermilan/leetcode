public class Solution {
    /*
    time:O(mn)
    space:O(1)
    */
    public int strStr(String haystack, String needle) {
        if(haystack==null)
            return -1;
        if(needle==null||needle.length()==0)
            return 0;
        int m=haystack.length();
        int n=needle.length();
        for(int i=0;i<=m-n;i++){
            int k=i;
            int j=0;
            for(;j<n;j++){
                if(needle.charAt(j)==haystack.charAt(k)){
                    k++;
                    continue;
                }else
                    break;
            }
            if(j==n)
                return i;
        }
        return -1;
    }
}