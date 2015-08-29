public class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        int startPos=0;
        int maxLength=1;
        for(int i=0;i<n;i++){
            dp[i][i]=true;
            if(i+1<n){
                if(s.charAt(i)==s.charAt(i+1)){
                    dp[i][i+1]=true;
                    startPos=i;
                    maxLength=2;
                }else
                    dp[i][i+1]=false;
            }
        }
        for(int len=3;len<=n;len++){
            for(int j=0;j<=n-len;j++){
                int start=j,end=j+len-1;
                if(dp[start+1][end-1]&&s.charAt(start)==s.charAt(end)){
                    dp[start][end]=true;
                    startPos=start;
                    maxLength=len;
                }else
                    dp[start][end]=false;
            }
        }
        return s.substring(startPos,startPos+maxLength);
    }
}