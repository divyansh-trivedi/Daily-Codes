class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int first[] = new int[26];
        int last[] = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        for(int i=0; i<n; i++){
            int idx = s.charAt(i)-'a';
            if(first[idx] == -1){
                first[idx] = i;
            }
            last[idx] = i;
        }
        int c = 0;
        for(int i=0; i<26; i++){
            if(first[i]!=-1 && first[i]<last[i]){
                HashSet<Character> set = new HashSet<>();
                for(int j=first[i]+1; j<last[i]; j++){
                    set.add(s.charAt(j));
                }
                c += set.size();
            }
        }
        return c;
    }
}