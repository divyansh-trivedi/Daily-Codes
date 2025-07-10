class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String ar[] = s.split("\\s+");
        String ans ="";
        int n = ar.length;
        for(int i=n-1;i>=0;i--){
            ans += ar[i];
            if(i>0)ans += " ";
        }
        return ans;
    }
}