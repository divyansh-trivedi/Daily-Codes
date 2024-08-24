class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        long num = Long.parseLong(n);
        long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));

        // Generate possible candidates
        List<Long> candidates = new ArrayList<>();
        candidates.add(mirror(prefix, len % 2 == 0));
        candidates.add(mirror(prefix + 1, len % 2 == 0));
        candidates.add(mirror(prefix - 1, len % 2 == 0));
        candidates.add((long) Math.pow(10, len - 1) - 1); // e.g., 999 for 1000
        candidates.add((long) Math.pow(10, len) + 1);     // e.g., 10001 for 9999

        // Find the closest palindrome
        long closest = -1;
        for (long candidate : candidates) {
            if (candidate != num) {
                if (closest == -1 ||
                    Math.abs(candidate - num) < Math.abs(closest - num) ||
                    (Math.abs(candidate - num) == Math.abs(closest - num) && candidate < closest)) {
                    closest = candidate;
                }
            }
        }

        return String.valueOf(closest);
    }

    private long mirror(long prefix, boolean evenLength) {
        String strPrefix = String.valueOf(prefix);
        StringBuilder sb = new StringBuilder(strPrefix);
        if (!evenLength) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return Long.parseLong(strPrefix + sb.reverse().toString());
    }
}
