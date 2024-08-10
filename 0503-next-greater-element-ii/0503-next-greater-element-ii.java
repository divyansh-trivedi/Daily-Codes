class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int ar[]= new int[nums.length];
        Stack<Integer> st= new Stack<>();
        int n=nums.length;

        for(int i=n-1;i>=0;i--)st.push(nums[i]);


        for(int i=n-1;i>=0;i--){
            
             while(!st.isEmpty()&& st.peek()<=nums[i]){
                 st.pop();
                
             }
            

             if(st.isEmpty())
             ar[i]=-1;
             else
             ar[i]=st.peek();

             st.push(nums[i]);
        }

        return ar;
        
    }
}