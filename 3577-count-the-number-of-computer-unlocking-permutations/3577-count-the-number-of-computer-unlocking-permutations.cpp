class Solution {
const int mod = 1e9+7;
public:
    int countPermutations(vector<int>& cmp) {
        long long res = 1;
        int n = cmp.size();
        for(int i=1;i<n;i++){
            if(cmp[i] <= cmp[0])return 0;

            res = (res * i)%mod;
        }
        return res;
    }
};

/*  complexity = [1,2,3]

0 1 2
0 2 1


Input: complexity = [3,3,3,4,4,4]

Output: 0
[_ _ _ _ _ _ ]
[3 2 3 4 4 4 ]
[] */