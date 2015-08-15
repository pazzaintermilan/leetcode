class MyQueue {
    // Push element x to the back of queue.
    Stack<Integer> stack = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        Stack<Integer> stackAuxi=new Stack<Integer>();
        while(!stack.isEmpty())
            stackAuxi.push(stack.pop());
        stack.push(x);
        while(!stackAuxi.isEmpty())
            stack.push(stackAuxi.pop());
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack.pop();
    }

    // Get the front element.
    public int peek() {
        return stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}