public class Solution {
    /*
    time: O(3^n)
    space: O(n)
    */
    public List<String> letterCombinations(String digits) {
        String[] dic={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> ret=new ArrayList<String>();
        int len=digits.length();
        if(len==0)
            return ret;
        char[] ch=new char[len];
        dfs(digits,dic,ret,ch,0,len);
        return ret;
    }
    
    private void dfs(String digits,String[] dic,List<String> ret,char[] ch,int pos,int len){
        if(pos==len){
            ret.add(String.valueOf(ch));
            return;
        }else{
            int idx=digits.charAt(pos)-'0';
            String str=dic[idx];
            for(int i=0;i<str.length();i++){
                ch[pos]=str.charAt(i);
                dfs(digits,dic,ret,ch,pos+1,len);
            }
        }
    }
}