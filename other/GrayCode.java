public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result=new ArrayList<Integer>();
        int size=1<<n;
        for(int i=0;i<size;i++){
            int gray=(i>>1)^i;
            result.add(gray);
        }
        return result;
    }
}