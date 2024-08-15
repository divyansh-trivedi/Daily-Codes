class Solution {
    // different than gas station, as the starting point is fixed
    // and bills have different nomination, 2 $10s cannot be used as $15 change

    public boolean lemonadeChange(int[] bills) {
        int fiveCnt = 0, tenCnt = 0;
        
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveCnt++;
            } else if (bills[i] == 10) {
                tenCnt++;
                fiveCnt--;
            } else {
                if (tenCnt > 0) {
                    tenCnt--; // if have 10, use 10 first, as 5 is more flexble.
                } else {
                    fiveCnt -= 2; // use five to pay 10 change.
                }

                fiveCnt--; // use to pay the rest 5 change.
            }

            if (fiveCnt < 0) return false;
        }

        return true;

    }
}