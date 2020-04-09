class MyQueue {
    
    Stack stack;
    Stack temp;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
        temp = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
        } else {
            while(!stack.isEmpty()) {
                temp.push(stack.pop());
            }
            stack.push(x);
            while(!temp.isEmpty()) {
                stack.push(temp.pop());
            }
        } 
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return (int)stack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return (int)stack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
