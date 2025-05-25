class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int totalLength = 0;
        boolean hasCenter = false;

        for (String word : map.keySet()) {
            String rev = new StringBuilder(word).reverse().toString();
            int count = map.get(word);

            if (!word.equals(rev)) {
                if (map.containsKey(rev)) {
                    int pairCount = Math.min(count, map.get(rev));
                    totalLength += 4 * pairCount;
                    map.put(word, map.get(word) - pairCount);
                    map.put(rev, map.get(rev) - pairCount);
                }
            } else {
                
                int pairCount = count / 2;
                totalLength += 4 * pairCount;
                if (count % 2 == 1) {
                    hasCenter = true;
                }
            }
        }

        if (hasCenter) totalLength += 2;

        return totalLength;
    }
}
