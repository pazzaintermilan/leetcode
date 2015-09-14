public class Solution {
    public String reverseWords(String s) {
        Stack<String> stk = new Stack<String>();
        int start = 0, end=0;
        int len = s.length();
        while(start<len && s.charAt(start)==' ')
            start++;
        end = start;
        while(end<len){
            while(end<len && s.charAt(end)!=' ')
                end++;
            String str = s.substring(start,end);
            stk.push(str);
            start=end+1;
            while(start<len && s.charAt(start)==' ')
                start++;
            end=start;
        }
        StringBuilder sb = new StringBuilder();
        boolean first=true;
        while(!stk.isEmpty()){
            if(first){
                sb.append(stk.pop());
                first=false;
            }else{
                sb.append(" "+stk.pop());
            }
        }
        return String.valueOf(sb);
    }
}