class Solution {
    public long dividePlayers(int[] skill) {
        int n=skill.length;
        int team=n/2;
        int ts=0;
        int fre[]= new int[1001];

        for(int i:skill){
            fre[i]++;
            ts+=i;
        }
        if(ts%team!=0)return -1;
        int target=ts/team;
        long res=0;

        for(int i:skill){
         if(fre[i]==0)continue;
         
         fre[i]--;

         int another=target-i;
         if(fre[another]==0)return -1;

         fre[another]--;
        res=res+(long)i*(long)another;
        }
        return res;
    }
}