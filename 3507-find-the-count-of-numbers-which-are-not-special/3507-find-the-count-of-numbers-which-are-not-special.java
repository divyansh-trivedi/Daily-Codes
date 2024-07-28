class Solution {
    public int nonSpecialCount(int l, int r) {
        int specialCount = 0;
        int sqrtL = (int) Math.ceil(Math.sqrt(l));
        int sqrtR = (int) Math.floor(Math.sqrt(r));
        while (sqrtL <= sqrtR) {
            if (isPrime(sqrtL++)) {
                specialCount++;
            }
        }
        return (r + 1 - l) - specialCount;
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        int sqrt = (int) Math.sqrt(num);
        for (int i = 5; i <= sqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}