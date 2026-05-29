class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack ;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    
    public void push(int val) {
        //For a normal stack you wont care about the value being pushed

        stack.push(val);
        //For a minStack , we have to update the min value whenever if encounter a smaller val
        //Temporarily behaves like a normal stack

        minStack.push(minStack.isEmpty() ? val : Math.min(minStack.peek() , val));
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
