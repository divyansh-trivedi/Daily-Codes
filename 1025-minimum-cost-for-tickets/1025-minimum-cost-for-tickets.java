class Solution {
    Integer memo[][] = new Integer[366][400];
    public int mincostTickets(int[] days, int[] costs) {
        return solve(days,costs,0,0);
    }
    public int solve(int [] days,int[] costs, int index,int val){
        if(index==days.length){
            return 0;
        }
        if(memo[index][val]!=null){
            return memo[index][val];
        }
        if(val>=days[index]){
            return memo[index][val]=solve(days,costs,index+1,val);
        }
        int d1= costs[0]+solve(days,costs,index+1,days[index]);
        int d7=costs[1] + solve(days,costs,index+1,days[index]+6);
        int d30=costs[2]+solve(days,costs,index+1,days[index]+29);
        return memo[index][val]=Math.min(d1,Math.min(d7,d30));
    }
}