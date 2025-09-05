typedef long long ll;
class Solution {
public:
    int makeTheIntegerZero(int num1, int num2) {
        for(int k =1; k<=60; ++k) {
            ll trgt =num1-1LL*k*num2;
            if(trgt>=k && __builtin_popcountll(trgt)<=k) 
                return k;           
        }
        return -1;

    }
};