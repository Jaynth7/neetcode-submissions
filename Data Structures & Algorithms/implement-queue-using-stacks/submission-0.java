class MyQueue {
    Stack<Integer> stackPush ;
    Stack<Integer> stackPop ;

    public MyQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }
    
    public void push(int x) {
        stackPush.push(x);
    }
    
    public int pop() {
        shiftStacks();
        return stackPop.pop();
    }
    
    public int peek() {
        shiftStacks();
        return stackPop.peek();
    }
    
    public boolean empty() {
        return stackPush.isEmpty() && stackPop.isEmpty();
    }

    private void shiftStacks(){
        if(stackPop.isEmpty()){
            while(!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
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