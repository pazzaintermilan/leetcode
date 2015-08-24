public class Solution {
    /*
    time: O(logn)
    space: O(1)
    */
    public double myPow(double x, int n) {
        if(x==0)
            return 0;
        if(n==0)
            return 1;
        double ret = myPow(x, n/2);
        if(n%2==0)
            return ret*ret;
        else{
            if(n>0)
                return ret*ret*x;
            else
                return ret*ret/x;
        }
    }
}