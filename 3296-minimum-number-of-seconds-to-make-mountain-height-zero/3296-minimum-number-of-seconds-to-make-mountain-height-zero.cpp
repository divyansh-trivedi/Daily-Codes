class Solution {
public:
long long findn(long long t, int w){
    int high= INT_MAX; long long low=0;
    while(high>=low){
        long long mid= (high+low)/2;
        if(1LL*mid*(mid+1)/2 <= t/w){
            low=mid+1;
        }
        else high= mid-1;
    }
    return high;
}
bool check(long long t, vector<int>& work, int h){
    for(int i=0; i<work.size(); i++){
        long long n= findn(t, work[i]);
        h -= n;
        if(h<=0) return true;
    }
    return false;
}
    long long minNumberOfSeconds(int height, vector<int>& work) {
        long long n= work.size();
        long long high= 1e17; long long low=0;
        while(high>=low){
            long long mid= (high+low)/2;
            if(check(mid, work, height)){
                high=mid-1;
            }
            else low= mid+1;
        }
        return low;
    }
};