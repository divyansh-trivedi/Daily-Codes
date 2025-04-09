class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set= new HashSet<>();

        for(int i:nums)set.add(i);
if(set.size()==1&&nums[0]==k)return 0;
        int n=-1;
        boolean flag=false;
        for(int i:set){
            
            if(i>k)n++; 
            if(i<k){flag=true;break;}
    }
        if(flag)return -1;
if(n==-1)return n;
       return n+1;
        
    }
}