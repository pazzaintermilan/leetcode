public class Solution {
    public String countAndSay(int n) {
        String s ="1";
        if(n==1)
            return s;
        for(int i=1;i<n;i++){
            StringBuffer buffer = new StringBuffer();
            int count=1;
            for(int j=1;j<s.length();j++){
                if(s.charAt(j)==s.charAt(j-1))
                    count++;
                else{
                    buffer.append(count);
                    buffer.append(s.charAt(j-1));
                    count=1;
                }
            }
            buffer.append(count);
            buffer.append(s.charAt(s.length()-1));
            s=buffer.toString();
        }
        return s;
    }
}