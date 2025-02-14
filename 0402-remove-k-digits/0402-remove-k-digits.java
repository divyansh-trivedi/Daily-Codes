class Solution {
    public String removeKdigits(String num, int k) {
        Deque <Integer> st = new LinkedList<>();
        int i =0 ;
        while(i<num.length()){
            int digit = num.charAt(i++) -'0';
            while(!st.isEmpty()&& k>0 && st.peekLast() > digit){
                st.removeLast();
                k--;
            }
            st.addLast(digit);
        }

        while(k>0 && !st.isEmpty()){
            st.removeLast();
            k--;
        }
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()&&st.peekFirst()==0)
            st.removeFirst();
        while(!st.isEmpty()){
            str.append(st.removeFirst());
        }
        return str.length() == 0? "0" :str.toString();

    }
}