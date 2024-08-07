import java.util.*;

class Solution {
    public int minimumPushes(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char a : word.toCharArray()) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        // Convert map entries to a list and sort by frequency using a lambda
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        int ans = 0;
        int t = 0;
        int r = 1;

        // ans 
        for (Map.Entry<Character, Integer> entry : entryList) {
            ans += entry.getValue() * r;
            t++;
            if (t == 8) {
                r += 1;
                t = 0;
            }
        }
        return ans;
    }

}