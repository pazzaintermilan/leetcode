public class Solution {
    /*
    time: log(n)
    space: C
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