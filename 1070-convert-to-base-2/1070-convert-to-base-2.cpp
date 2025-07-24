class Solution {
public:
    string baseNeg2(int n) {
        string res="";
        if(n==0)return "0";
        while(n!=0){
            int rem = n%-2;
            n = n/-2;

            if(rem<0){
                rem -= -2;
                n++;
            }
            res = to_string(rem)+res;

        }
        return res;
    }
};