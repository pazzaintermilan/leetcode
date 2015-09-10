public class Solution {
    /*
    time: O(m*n)
    space: O(n)
    */
    public int numDistinct(String s, String t) {
        int len=t.length();
        int[] dp=new int[len+1];
        dp[0]=1;
        for(int i=0;i<s.length();i++){
            for(int j=t.length()-1;j>=0;j--)
                dp[j+1]+=s.charAt(i)==t.charAt(j)?dp[j]:0;
        }
        return dp[t.length()];
    }
}