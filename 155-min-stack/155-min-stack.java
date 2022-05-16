class MinStack {
    int[] stack;
    int pointer;
    int[] min;
    
    public MinStack() {
        stack = new int[30000];
        min = new int[30000];
        pointer = 0;
    }
    
    public void push(int val) {
        stack[pointer++] = val;
        min[pointer] = (pointer==1)?val:Math.min(min[pointer-1], val);
    }
    
    public void pop() {
        min[pointer] = min[pointer-1];
        pointer--;
        
    }
    
    public int top() {
        return stack[pointer-1];
    }
    
    public int getMin() {
        return min[pointer];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */