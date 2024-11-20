
 class Node{
        int first;
        int second;

        Node(int first, int second){
            this.first=first;
            this.second=second;
        }
    }
    class MinStack {
   
    Stack<Node> st;
    public MinStack() {
        st= new Stack<>();

    }
    
    public void push(int val) {
    int min=st.isEmpty()?val:Math.min(st.peek().second,val);
        st.push(new Node(val,min));
    }
    
    public void pop() {
       st.pop();
    }
    
    public int top() {
        return st.peek().first;
    }
    
    public int getMin() {
        return st.peek().second;
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