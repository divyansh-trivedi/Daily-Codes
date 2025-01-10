import java.util.*;

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFreq = new int[26];
        for (String b : words2) {
            int[] freq = new int[26];
            for (char c : b.toCharArray()) {
                freq[c - 'a']++;
                maxFreq[c - 'a'] = Math.max(maxFreq[c - 'a'], freq[c - 'a']);
            }
        }

        List<String> result = new ArrayList<>();
        for (String a : words1) {
            int[] freqA = new int[26];
            for (char c : a.toCharArray()) {
                freqA[c - 'a']++;
            }

            boolean universal = true;
            for (int i = 0; i < 26; i++) {
                if (freqA[i] < maxFreq[i]) {
                    universal = false;
                    break;
                }
            }

            if (universal) result.add(a);
        }

        Collections.sort(result);
        return result;
    }
}
