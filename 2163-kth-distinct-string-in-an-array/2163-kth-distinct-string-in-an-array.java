class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String,Integer> map= new TreeMap<>();

        for(String i: arr)
           map.put(i,map.getOrDefault(i,0)+1);
           int c=0;
          
        
        for(String i:arr){
            if(map.get(i)==1)c++;
            if(c==k)
            return i;
        }
        return "";

    }
}