public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0)
            return 0;
        int i=0,j=0;
        int n=s.length();
        int maxLen=0;
        boolean exist[] = new boolean[256];
        while(j<n){
            if(exist[s.charAt(j)]){
                maxLen=Math.max(maxLen,j-i);
                while(s.charAt(i)!=s.charAt(j)){
                    exist[s.charAt(i)]=false;
                    i++;
                }
                i++;
            }
            else
                exist[s.charAt(j)] = true;
            j++;
        }
        maxLen = Math.max(maxLen, j - i);
        return maxLen;
    }
}