public class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stk=new Stack<Integer>();
        int result = 0;
        int[] newHeight=new int[height.length+1];
        for(int i=0;i<height.length;i++)
            newHeight[i]=height[i];
        newHeight[newHeight.length-1]=0;
        height=newHeight;
        for(int i=0;i<height.length;){
            if (stk.isEmpty()||height[i]>height[stk.peek()])
                stk.push(i++);
            else{
                int tmp = stk.pop();
                result=Math.max(result,height[tmp]*(stk.isEmpty()?i:i-stk.peek()-1));
            }
        }
        return result;
    }
}