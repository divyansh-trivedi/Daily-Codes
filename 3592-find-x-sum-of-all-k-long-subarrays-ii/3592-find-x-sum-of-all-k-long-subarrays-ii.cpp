class Solution {
public:
    typedef pair<long long, long long> pp;
    set<pp> prim, sec;
    int x;
    long long sum = 0;
    void insertInSet(pp p){
        if(prim.size() < x || p > *prim.begin()){
            prim.insert(p);
            sum += p.first*p.second;
            if(prim.size() > x){
                pp p1 = *prim.begin();
                sum -= 1LL*p1.first*p1.second;
                prim.erase(p1);
                sec.insert(p1);
            }
        }else sec.insert(p);
    }
    void removeFromSet(pp p){
        if(prim.count(p)){
            sum -= p.first*p.second;
            prim.erase(p);
            if(sec.size()){
                pp p1 = *sec.rbegin();
                sec.erase(p1);
                prim.insert(p1);
                sum += 1LL*p1.first*p1.second;
            }
        }else sec.erase(p);
    }
    vector<long long> findXSum(vector<int>& nums, int k, int x) {
        this->x = x;
        unordered_map<long long, long long> mp;
        int l = 0, r = 0, n = nums.size();
        vector<long long> ans;
        while(r < n){
            if(mp[nums[r]] > 0)removeFromSet({mp[nums[r]], nums[r]});
            mp[nums[r]]++;
            insertInSet({mp[nums[r]], nums[r]});
            if(r-l+1 == k){
                ans.push_back(sum);
                removeFromSet({mp[nums[l]], nums[l]});
                mp[nums[l]]--;
                if(mp[nums[l]] == 0)mp.erase(nums[l]);
                else insertInSet({mp[nums[l]], nums[l]});
                l++;
            }
            r++;
        }
        return ans;
    }
};