class Solution {
    static final int MAX_LIMIT = 100000;
    static final int MOD_CONST = 1000000007;

    public int sumOfFlooredPairs(int[] nums) {
        int[] freqArray = new int[MAX_LIMIT + 1];
        
        for (int num : nums) {
            freqArray[num]++;
        }

        for (int idx = 1; idx <= MAX_LIMIT; idx++) {
            freqArray[idx] += freqArray[idx - 1];
        }

        long finalSum = 0;

        for (int base = 1; base <= MAX_LIMIT; base++) {
            if (freqArray[base] > freqArray[base - 1]) {
                long quotientTotal = 0;
                
                for (int factor = 1; base * factor <= MAX_LIMIT; factor++) {
                    int lowerLimit = base * factor - 1;
                    int upperLimit = base * (factor + 1) - 1;
                    quotientTotal += (freqArray[Math.min(upperLimit, MAX_LIMIT)] - freqArray[lowerLimit]) * (long) factor;
                }
                
                finalSum = (finalSum + (quotientTotal % MOD_CONST) * (freqArray[base] - freqArray[base - 1])) % MOD_CONST;
            }
        }

        return (int) finalSum+0
        ;
    }
}