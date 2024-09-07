class Solution {
    public int maxJump(int[] stones) {
        if(stones.length==1)return stones[0];
        if(stones.length==2)return Math.max(stones[0],stones[1]);
        
        int max=0;
        for(int i=0;i<stones.length-2;i++)max=Math.max(max,stones[i+2]-stones[i]);
        
        return max;

    }
}