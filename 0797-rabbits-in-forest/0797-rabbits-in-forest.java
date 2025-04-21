class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer>  map = new HashMap<>();
        int n = answers.length;
        for(int i:answers)
        map.put(i, map.getOrDefault(i,0)+1);

        int cnt =0;
        for(int key : map.keySet()){
            int val  = map.get(key);
            int count = val /(key+1);

            if(val%(key+1) != 0)count++;

             cnt += count*(key+1);
        }
        return cnt;
    }
}