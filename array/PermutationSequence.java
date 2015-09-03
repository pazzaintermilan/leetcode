public class Solution {
    /*
    time: O(n^2)
    space: O(n)
    */
    public String getPermutation(int n, int k) {
        int i,j,f=1;
        // left part of s is partially formed permutation, right part is the leftover chars.
        char[] ret=new char[n];
        for(i=1;i<=n;i++){
            f*=i;
            ret[i-1]=(char)('0'+i);
        }
        k--;
        for(i=0;i<n;i++){
            if(k<0)
                break;
            f=f/(n-i);
            j=i+k/f; // calculate index of char to put at s[i]
            char c=ret[j];
            // remove c by shifting to cover up (adjust the right part).
            for(;j>i;j--)
                ret[j]=ret[j-1];
            ret[i]=c;
            k%=f;
        }
        return String.valueOf(ret);
    }
}