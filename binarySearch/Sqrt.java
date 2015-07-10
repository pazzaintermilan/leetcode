public class Solution {
    @method1
    /*
    time: log(n)
    space: C
    */
    public int mySqrt(int x) {
        if(x<2)
            return x;
        int preLeft=1,left=1,right=x/2;
        while(left<=right){
            int mid=(left+right)/2;
            if(x/mid==mid)
                return mid;
            else if(x/mid>mid){
                preLeft=mid;
                left=mid+1;
            }else
                right=mid-1;
        }
        return preLeft;
    }

    @method2
    /*
    time: log(n)
    space: C
    */
    public int mySqrt(int x) {
        if(x<2)
            return x;
        int left=1, right=x/2;
        while(true){
            int mid=(right+left)/2;
            if(mid>x/mid)
                right=mid-1;
            else{
                if(mid+1>x/(mid+1))
                    return mid;
                left=mid+1;
            }
        }
    }
}