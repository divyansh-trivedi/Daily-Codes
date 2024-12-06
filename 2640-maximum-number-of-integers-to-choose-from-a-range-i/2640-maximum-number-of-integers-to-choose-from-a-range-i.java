class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int sum=0;
        Set<Integer> set =new HashSet<>();
        for(int i:banned)set.add(i);
        ArrayList<Integer> ar= new ArrayList<>();

        for(int i=1;i<=n;i++){
            if(!set.contains(i)){
                sum+=i;
                if(sum>maxSum)break;
                ar.add(i);
            }
        }
        return ar.size();
    }
}