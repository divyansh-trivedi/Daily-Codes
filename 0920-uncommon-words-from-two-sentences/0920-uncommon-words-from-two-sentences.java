class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String ar1[]= s1.split(" ");
        String ar2[]=s2.split(" ");
        Map<String , Integer> map= new HashMap<>();

        for(String s:ar1)map.put(s, map.getOrDefault(s,0)+1);
        for(String s:ar2)map.put(s,map.getOrDefault(s,0)+1);
        
        List<String> list= new ArrayList<>();


      for(String k:map.keySet()){
        if(map.get(k)==1)list.add(k);
      }
       return list.toArray(new String[0]);
      
    }
}