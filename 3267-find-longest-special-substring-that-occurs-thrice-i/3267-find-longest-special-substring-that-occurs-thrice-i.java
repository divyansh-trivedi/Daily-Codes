class Solution {
    public boolean check(String s){
        int n=s.length();
        char xx =s.charAt(0);
        for(char ch : s.toCharArray()){
            if(ch!=xx)
            return false;
        }
        return true;
    }
    public int maximumLength(String s) {
        HashMap<String,Integer> map = new HashMap<>();
        int n=s.length();
        for(int i=0;i<n;i++){
          for(int j=i;j<n;j++)
           map.put(s.substring(i,j+1), map.getOrDefault(s.substring(i,j+1),0)+1);
        }
        int max=-1;
        for(String key : map.keySet()){
            boolean flag =false;
            if(map.get(key)>=3){
                flag=true;
                flag = check(key);
            }
            if(flag)
            max=Math.max(max, key.length());
        }
        return max;
    }
}