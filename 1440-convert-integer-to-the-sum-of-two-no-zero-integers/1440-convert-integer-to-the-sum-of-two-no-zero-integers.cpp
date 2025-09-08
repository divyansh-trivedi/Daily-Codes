class Solution {
public:
    bool helper(int n){
        while(n!=0){
            if(n%10==0) return true;
            n=n/10;
        }
        return false;
    }
    vector<int> getNoZeroIntegers(int n) {
        for(int i=1;i<n;i++){
            int a=i,b=n-i;

            if((!helper(a)) && (!helper(b)) ){
                return {a,b};
            }
        }
        return {-1,-1};
    }
};