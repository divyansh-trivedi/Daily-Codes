class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<String,Integer> map= new HashMap<>();

        for(int i[]:matrix){
            String str="";
            int first=i[0];
            for(int j:i) str+=(j==first)?"s":"b";
            map.put(str,map.getOrDefault(str,0)+1);
        }
int max=-1;
        for(Map.Entry<String,Integer> entry:map.entrySet()){
max=Math.max(max,entry.getValue());
        }

        return max;

    }
}