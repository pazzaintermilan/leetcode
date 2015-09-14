public class Solution {
    public int myAtoi(String str) {
        if(str==null||str.length()==0)
            return 0;
        int index=0;
        int flag=1;
        int num=0;
        while(index<str.length()&&str.charAt(index)==' ')
            index++;
        if(str.charAt(index)=='+'){
            flag=1;
            index++;
        }
        else if(str.charAt(index)=='-'){
            flag=-1;
            index++;
        }
        for(int i=index;i<str.length();i++){
            if(str.charAt(i)<'0'||str.charAt(i)>'9')
                break;
            int digit=str.charAt(i)-'0';
            if(num>Integer.MAX_VALUE/10||(num==Integer.MAX_VALUE/10&&digit>Integer.MAX_VALUE%10))
                return flag>0?Integer.MAX_VALUE:Integer.MIN_VALUE;
            num=num*10+digit;
        }
        return num*flag;
    }
}