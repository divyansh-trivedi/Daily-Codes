class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map= new HashMap<>();
        for(char c:s.toCharArray())
        map.put(c,map.getOrDefault(c,0)+1);

         List<Character> list = new ArrayList<>(map.keySet());
         Collections.sort(list,(a,b)->{
int fre= map.get(b).compareTo(map.get(a));
if(fre==0)
return a.compareTo(b);
else
return fre;
         });

         StringBuilder res= new StringBuilder();
         for(char c:list){
            int freq=map.get(c);
            for(int i=0;i<freq;i++){
                res.append(c);
            }
         }
         return res.toString();
            }
}