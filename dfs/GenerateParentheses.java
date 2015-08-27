public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret=new ArrayList<String>();
        dfs(ret,n,0,0,"");
        return ret;
    }
    
    private void dfs(List<String> ret,int n,int leftPos,int rightPos,String str){
        if(leftPos==n&&rightPos==n){
            ret.add(str);
            return;
        }
        if(leftPos<n)
            dfs(ret,n,leftPos+1,rightPos,str+"(");
        if(leftPos>rightPos)
            dfs(ret,n,leftPos,rightPos+1,str+")");
    }
}