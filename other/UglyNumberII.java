public class Solution {
    /*
    Time limit exceeded
    */
    @method1
    public int nthUglyNumber(int n) {
        int cur=1;
        for(int i=1;i<=n;){
            if(isUgly(cur)){
                i++;
                cur++;
            }else
                cur++;
        }
        return cur;
    }
    
    public boolean isUgly(int num) {
        if(num==0)
            return false;
        while(num%2==0)
            num=num/2;
        while(num%3==0)
            num=num/3;
        while(num%5==0)
            num=num/5;
        if(num==1)
            return true;
        else
            return false;
    }

    @method2
    public int nthUglyNumber(int n) {
        if(n==1)
            return 1;
        ArrayList<Integer> list=new ArrayList<Integer>();
        int base2=0,base3=0,base5=0;
        int ret=1;
        list.add(1);
        while(n>1){
            int v2=2*list.get(base2);
            int v3=3*list.get(base3);
            int v5=5*list.get(base5);
            ret=Math.min(Math.min(v2,v3),v5);
            list.add(ret);
            if(ret==v2)
                base2++;
            if(ret==v3)
                base3++;
            if(ret==v5)
                base5++;
            n--;
        }
        return ret;
    }
}