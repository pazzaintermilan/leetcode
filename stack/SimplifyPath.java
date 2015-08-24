public class Solution {
    /*
    time: O(n)
    space: O(n)
    */
    public String simplifyPath(String path) {
        Stack<String> stk=new Stack<String>();
        int i=0;
        while(i<path.length()){
            int end=i+1;
            while(end<path.length()&&path.charAt(end)!='/')
                end++;
            String sub=path.substring(i+1,end);
            if(sub.length()>0){
                if(sub.equals("..")){
                    if(!stk.isEmpty())
                        stk.pop();
                }else if(!sub.equals("."))
                    stk.push(sub);
            }
            i=end;
        }
        if(stk.isEmpty())
            return "/";
        StringBuffer buffer=new StringBuffer();
        ArrayList<String> list=new ArrayList<String>();
        while(!stk.empty())
            list.add(0,stk.pop());
        for(int j=0;j<list.size();j++)
            buffer.append("/"+list.get(j));
        return String.valueOf(buffer);
    }
}