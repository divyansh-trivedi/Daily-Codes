class Solution {
public:
    string s;


    int dp[11][2][3][3][3][3][3][3][3][3][3][3][2];

    int rec(int index, bool tight, int one, int two, int three, int four,
            int five, int six, int seven, int eight, int nine, int zero,
            bool lead) {

        if (index == s.size()) {
            return one == 2 || two == 2 || three == 2 || four == 2 ||
                   five == 2 || six == 2 || seven == 2 || eight == 2 ||
                   nine == 2 || zero == 2;
        }

        int& ans = dp[index][tight][one][two][three][four][five][six][seven]
                     [eight][nine][zero][lead];
        if (ans != -1)
            return ans;

        int lb = 0;
        int ub = tight ? s[index] - '0' : 9;
        ans = 0;

        for (int i = lb; i <= ub; i++) {
            int n_one = one, n_two = two, n_three = three, n_four = four,
                n_five = five, n_six = six, n_seven = seven, n_eight = eight,
                n_nine = nine, n_zero = zero;

            if (i == 1)
                n_one++;
            else if (i == 2)
                n_two++;
            else if (i == 3)
                n_three++;
            else if (i == 4)
                n_four++;
            else if (i == 5)
                n_five++;
            else if (i == 6)
                n_six++;
            else if (i == 7)
                n_seven++;
            else if (i == 8)
                n_eight++;
            else if (i == 9)
                n_nine++;
            else if (i == 0 && lead)
                n_zero++;

            ans +=
                rec(index + 1, tight && (i == ub), min(n_one, 2), min(n_two, 2),
                    min(n_three, 2), min(n_four, 2), min(n_five, 2),
                    min(n_six, 2), min(n_seven, 2), min(n_eight, 2),
                    min(n_nine, 2), min(n_zero, 2), lead || i > 0);
        }

        return ans;
    }

    int numDupDigitsAtMostN(int n) {
        for (int i0 = 0; i0 < 11; i0++)
            for (int i1 = 0; i1 < 2; i1++)
                for (int i2 = 0; i2 < 3; i2++)
                    for (int i3 = 0; i3 < 3; i3++)
                        for (int i4 = 0; i4 < 3; i4++)
                            for (int i5 = 0; i5 < 3; i5++)
                                for (int i6 = 0; i6 < 3; i6++)
                                    for (int i7 = 0; i7 < 3; i7++)
                                        for (int i8 = 0; i8 < 3; i8++)
                                            for (int i9 = 0; i9 < 3; i9++)
                                                for (int i10 = 0; i10 < 3;
                                                     i10++)
                                                    for (int i11 = 0; i11 < 3;
                                                         i11++)
                                                        for (int i12 = 0;
                                                             i12 < 2; i12++)
                                                            dp[i0][i1][i2][i3]
                                                              [i4][i5][i6][i7]
                                                              [i8][i9][i10][i11]
                                                              [i12] = -1;

        s = to_string(n);
        return rec(0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }
};