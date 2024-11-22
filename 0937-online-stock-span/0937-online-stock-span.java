class Pair{
    int ele;
    int idx;
    Pair(int ele , int pg){
        this.ele=ele;
        this.idx=pg;

    }
}
class StockSpanner {
    Stack<Pair> st ;
    int idx2 ;
    public StockSpanner() {
        st = new Stack<>();
        idx2=-1;
    }
    
    public int next(int price) {
        idx2+=1;
      

        while(!st.isEmpty() && st.peek().ele <=price)
        st.pop();

        int ans = idx2 - (st.isEmpty()? -1 :st.peek().idx);
        st.push(new Pair(price ,idx2));

        return ans;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */