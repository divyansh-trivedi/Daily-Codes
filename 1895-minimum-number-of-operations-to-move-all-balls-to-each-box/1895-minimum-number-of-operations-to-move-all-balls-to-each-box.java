class Solution {
    public int[] minOperations(String boxes) {
        ArrayList<Integer>arr=new ArrayList<>();
        char[]ch=boxes.toCharArray();
        int n=ch.length;
        ArrayList<Integer>ones=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(ch[i]=='1'){
                ones.add(i);
            }
        }
        for(int i=0;i<n;i++){
            int sum=0;
            for(int x:ones){
                 sum+=Math.abs(i-x);
            }
            arr.add(sum);

        }
        int[]ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=arr.get(i);
        }
    return ans;
    }
}