public class Solution {
    /*
    time: O(n)
    space: O(1)
    */
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0)
            return "";
        String prefix=strs[0];
        for(int i=1;i<strs.length;i++){
            if(prefix.length()==0||strs[i].length()==0)
                return "";
            int len = Math.min(prefix.length(), strs[i].length());
            int j=0;
            for(;j<len;j++){
                if(prefix.charAt(j)!=strs[i].charAt(j))
                    break;
            }
            prefix=prefix.substring(0,j);
        }
        return prefix;
    }
}