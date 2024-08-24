class Solution {
    public String nearestPalindromic(String n) {
        int index = n.length() / 2;
        boolean even = n.length() % 2 == 0;
        long leftPart = Long.parseLong(n.substring(0, index + (even ? 0 : 1))); // Adjusted index

        // 5 cases
        List<Long> cases = new ArrayList<>();
        // converting ending digits to starting digits
        cases.add(getPalindrome(leftPart, even));
        // incrementing middle
        cases.add(getPalindrome(leftPart + 1, even));
        // decrementing middle
        cases.add(getPalindrome(leftPart - 1, even));
        // reduce digits by 1
        cases.add((long) Math.pow(10, n.length() - 1) - 1);
        // increase digits by 1
        cases.add((long) Math.pow(10, n.length()) + 1);

        long result = 0, diff = Long.MAX_VALUE, num = Long.parseLong(n);
        for (long c : cases) {
            if (c == num) continue; // Skip if candidate is the same as the original number
            long currDiff = Math.abs(num - c);
            if (diff > currDiff || (diff == currDiff && c < result)) {
                result = c;
                diff = currDiff;
            }
        }

        return String.valueOf(result);
    }

    private long getPalindrome(long leftPart, boolean even) {
        long result = leftPart;
        if (!even) leftPart /= 10; // Adjust if the length of the number is odd
        while (leftPart > 0) {
            result = result * 10 + (leftPart % 10);
            leftPart /= 10;
        }
        return result;
    }
}
