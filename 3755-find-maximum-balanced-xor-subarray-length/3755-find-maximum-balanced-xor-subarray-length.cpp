class Solution {
public:
    int maxBalancedSubarray(vector<int>& nums) {
        unordered_map<int , unordered_map<int ,int>> mp;
        mp[0][0] = -1;
        int xr = 0;
        int balance = 0;
        int ans = 0;
        int n = nums.size();
        for(int i = 0; i < n; i++){
            xr ^= nums[i];
            balance += (nums[i]%2 == 0)? 1 : -1;
            if(mp.count(xr) && mp[xr].count(balance)){
                int len = i - mp[xr][balance];
                ans = max(ans, len);
            }else 
                mp[xr][balance] = i  ;   
        }
        return ans;
    }
};

/* Input: nums = [3,1,3,2,0]
    xor = 0, balance  = 0, ans = 0;
i = 0 => xor = 3 , balance = -1, ans = 0; => map =>{ {0, {0,-1}}, {3, {-1, 0}}}
i = 1 => xor = 3^1 = 2 , balance = -2, ans = 0; => map =>{{0, {0,-1}},{3, {-1, 0}}, {2, {-2, 1}}}
i = 2 => xor = 2^3 = 1 , balance = -3, ans = 0; => map =>{{0, {0,-1}},{3, {-1, 0}}, {2, {-2, 1}}, {1, {-3, 2}}}
i = 3 => xor = 1^2 = 3 , balance = -2, ans = 0; => here xor exist in map but balance doesnt exist
    =>{{0, {0,-1}}, {3, {-1, 0,  -2, 3}}, {2, {-2, 1}}, {1, {-3, 2}}, {3, }}
i = 4 => xor = 3^0 = 3 , balance = -1, ans = 0; =>here xor exist in map and balance also exist 
     =>{{0, {0,-1}}, {3, {-1, 0,  -2, 3}}, {2, {-2, 1}}, {1, {-3, 2}}, {3, }}
    => update ans = i - map.get(3).get(-1) => length = 4 - 0 = 4 => ans = max(ans, length) = > ans = 4;
ans = 4;©leetcode */