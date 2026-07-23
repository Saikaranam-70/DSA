class Pair{
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class MinStack {
    Stack<Pair> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int value) {
        int min = 0;
        if(stack.isEmpty()) min = value;
        else{
            min = Math.min(stack.peek().y, value);
        }
        stack.push(new Pair(value, min));
    }
    
    public void pop() {
        if(!stack.isEmpty()) stack.pop();
    }
    
    public int top() {
        return stack.peek().x;
    }
    
    public int getMin() {
        return stack.peek().y;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */