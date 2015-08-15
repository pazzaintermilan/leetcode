public class Solution {
    /*
    time: O(n)
    space: O(n)
    */
    public boolean isValid(String s) {
        Stack<Character> stk=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('||ch=='{'||ch=='[')
                stk.push(ch);
            else{
                if(stk.isEmpty())
                    return false;
                char pre=stk.pop();
                if(pre=='('&&ch!=')'||pre=='{'&&ch!='}'||pre=='['&&ch!=']')
                    return false;
            }
        }
        return stk.isEmpty();
    }
}