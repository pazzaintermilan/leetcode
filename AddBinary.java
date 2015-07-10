public class Solution {
    /*
    time: O(n)
    space: O(1)
    */
    public String addBinary(String a, String b) {
        String ret=new String();
        int al=a.length()-1, bl=b.length()-1;
        int len=Math.max(al,bl);
        int sum=0;
        for(int i=len;i>=0;i--,al--,bl--){
            if(al>=0)
                sum+=a.charAt(al)-'0';
            if(bl>=0)
                sum+=b.charAt(bl)-'0';
            ret=String.valueOf((char)((sum&1)+'0'))+ret;
            sum=sum/2;
        }
        if(sum==0)
            return ret;
        else
            return "1"+ret;
    }
}