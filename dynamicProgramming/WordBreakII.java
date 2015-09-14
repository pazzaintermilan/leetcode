public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> ret=new ArrayList<String>();
        int len=s.length();
        boolean[] dp=new boolean[len+1];
        boolean[][] pre=new boolean[len+1][len];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=i-1;j>=0;j--){
                if(dp[j]&&dict.contains(s.substring(j,i))){
                    dp[i]=true;
                    pre[i][j]=true;
                }
            }
        }
        ArrayList<String> path=new ArrayList<String>();
        generate_path(s,pre,s.length(),path,ret);
        return ret;
    }

    public void generate_path(String s, boolean[][] pre, int cur, ArrayList<String> path, ArrayList<String> ret){
        if(cur==0){
            String tmp=new String();
            for(int i=path.size()-1;i>0;i--)
                tmp+=path.get(i)+" ";
            tmp+=path.get(0);
           // tmp.(tmp.end() - 1);
            ret.add(tmp);
        }
        for(int i=0;i<s.length();i++){
            if(pre[cur][i]){
                path.add(s.substring(i,cur));
                generate_path(s,pre,i,path,ret);
                path.remove(path.size()-1);
            }
        }
    }
}