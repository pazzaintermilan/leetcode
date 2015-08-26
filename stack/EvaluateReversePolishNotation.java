public class Solution {
<<<<<<< HEAD
<<<<<<< HEAD
    /*
    time: O(n)
    space: O(logn)
    */
=======
>>>>>>> feature
=======
>>>>>>> feature
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk=new Stack<Integer>();
        HashSet<String> set=new HashSet<String>(Arrays.asList("+", "-", "*", "/"));
        for(int i=0;i<tokens.length;i++){
            if(set.contains(tokens[i])){
                int num2=stk.pop();
                int num1=stk.pop();
                stk.push(operate(num1,num2,tokens[i]));
            }else
                stk.push(Integer.parseInt(tokens[i]));
        }
        return stk.pop();
    }
   
    public int operate(int num1,int num2,String operator){
        switch(operator){
            case "+":
                return num1+num2;
            case "-":
                return num1-num2;
            case "*":
                return num1*num2;
            case "/":
                return num1/num2;
        }
        return 0;
    }
}