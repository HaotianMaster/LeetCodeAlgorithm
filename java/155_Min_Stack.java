// Two stack.
class MinStack {
    Stack<Integer> st;
    Stack<Integer> min_st;
    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<>();
        min_st = new Stack<>();
    }
    
    public void push(int x) {
        st.push(x);
        if (!min_st.isEmpty()) {
            int min = min_st.peek();
            if (x <= min) {
                min_st.push(x);
            }
        }
        else {
            min_st.push(x);
        }
    }
    
    public void pop() {
        int x = st.pop();
        if (!min_st.isEmpty()) {
            if (x == min_st.peek()) {
                min_st.pop();
            }
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min_st.peek();
    }
}

// One stack.
class MinStack {
    Stack<Integer> st;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if (x <= min) {
            st.push(min);
            min = x;
        }
        st.push(x);
    }
    
    public void pop() {
        if (st.pop() == min) {
            min = st.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */