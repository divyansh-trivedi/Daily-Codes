class Solution {
    public static void check(int idx, int ar[], int target,List<List<Integer>> ans,List<Integer> ds){
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return ;
        }
        for(int i=idx;i<ar.length;i++){
            if(i>idx&&ar[i]==ar[i-1])continue;
            if(ar[i]>target) break;

            ds.add(ar[i]);
            check(i+1,ar,target-ar[i],ans,ds);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>  ans= new ArrayList<>();
        Arrays.sort(candidates);
        check(0, candidates ,target, ans ,new ArrayList<>());
        return ans;


    }
}