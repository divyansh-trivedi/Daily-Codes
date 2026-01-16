class Solution {
private:
    const int MOD=1e9 +7;
public:
    int maximizeSquareArea(int m, int n, vector<int>& hf, vector<int>& vf) {
        hf.push_back(1);
        hf.push_back(m);
        vf.push_back(1);
        vf.push_back(n);
        sort(hf.begin(),hf.end());
        sort(vf.begin(),vf.end());
        map<long long,long long>mpp;
        int w=hf.size();
        for(int i=0;i<w;i++){
            for(int j=i+1;j<w;j++){
                mpp[hf[j]-hf[i]]++;
            }
        }
        int w2=vf.size();
        long long mx=-1;
        for(int i=0;i<w2;i++){
            for(int j=i+1;j<w2;j++){
                if(mpp.find(vf[j]-vf[i])!=mpp.end()){
                    mx=max(mx,(long long)vf[j]-vf[i]);
                }
            }
        }
        if(mx==-1){
            return mx;
        }
        long long ans=(mx*mx)%MOD;
        return ans;
    }
};