class Solution {
    public int numberOfSubstrings(String s) {
        char[] sChar = s.toCharArray();
        int n = sChar.length;

        int[] prefix = new int[n];
        prefix[0] = sChar[0] == '1' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + (sChar[i] == '1' ? 1 : 0);
        }
        int next = n;
        int[] nextZero = new int[n];
        for (int i = n - 1; i>= 0; i--) {
            nextZero[i] = next;
            if (sChar[i] == '0') {
                next = i;
            }
        }

        int retVal = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n) {
                int oneCt = prefix[j] - (i > 0 ? prefix[i - 1] : 0);
                int zerCt = j - i + 1 - oneCt;
                if (oneCt >= zerCt * zerCt) {
                    // Count the current index
                    retVal++;

                    // Count all ones till the next zero
                    retVal += nextZero[j] - j - 1;

                    // Move to the next index that needs to be checked if we still have a subarray with
                    // dominant ones
                    j = nextZero[j];
                } else {
                    // Move to the next index that may create a subarray with dominant ones
                    j += zerCt * zerCt - oneCt;
                }
            }
        }
        return retVal;
    }
}