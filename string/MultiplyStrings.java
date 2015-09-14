public class Solution {
    public String multiply(String num1, String num2) {
        int l1=num1.length(),l2=num2.length();
        if(l1==0||l2==0)
            return "0";
        int[] digit=new int[l1+l2];

        for(int i=0;i<l1;i++){
            int carry=0;
            int n1=(int)(num1.charAt(l1-i-1)-'0');//Calculate from rightmost to left
            for(int j=0;j<l2;j++){
                int n2=(num2.charAt(l2-j-1)-'0');//Calculate from rightmost to left

                int sum=n1*n2+digit[i+j]+carry;
                carry=sum/10;
                digit[i+j]=sum%10;
            }
            if(carry>0)
                digit[i+l2]+=carry;
        }
        int start=l1+l2-1;
        while(digit[start]==0){
            start--;
            if(start<0)
                break;
        }
        if(start==-1)
            return "0";
        StringBuffer buffer=new StringBuffer();
        for(int i=start;i>=0;i--)
            buffer.append((char)(digit[i]+'0'));
        return String.valueOf(buffer);
    }
}