class Pair{
    String first;int  second;
    Pair(String  f, int s){
        first =f;
        second =s;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set= new HashSet<>();
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(beginWord,1));
        for(String s:wordList)set.add(s);

        set.remove(beginWord);
        while(!q.isEmpty()){
            Pair rem = q.poll();
            int steps = rem.second;
            String word = rem.first;

            if(word.equals(endWord)==true)return steps;

            for(int i=0;i<word.length();i++){
                for(char ch='a' ;ch<='z';ch++){
                    char ar[] = word.toCharArray();
                    ar[i] = ch;
                    String newWord = new String(ar);
                    if(set.contains(newWord)){
                        set.remove(newWord);
                        q.add(new Pair(newWord, steps+1));
                    }
                }
            }
        }
        return 0;
    }
}