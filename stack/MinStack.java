class MinStack {

    /*
    time: O(1) 
    space: O(n)
    */

    Stack<Integer> stk = new Stack<Integer>();
    Stack<Integer> minStk = new Stack<Integer>();
    
    public void push(int x) {
        if(minStk.isEmpty()||x<=minStk.peek())
            minStk.push(x);
        stk.push(x);
    }

    public void pop() {
        if(stk.peek().intValue()==minStk.peek().intValue())  // be careful to convert Integer to int, then compare int value
            minStk.pop();
        stk.pop();
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return minStk.peek();
    }
}