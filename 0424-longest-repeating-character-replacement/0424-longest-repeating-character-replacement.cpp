class Solution {
public:
    int characterReplacement(string s, int k) {
        vector<int> hash(26,0);
        int left =0;
        int maxFreq = 0;
        int maxWindow = 0;
        for(int right =0 ;right<s.size();right++){
            hash[s[right] -'A']++;
            maxFreq = max(maxFreq,hash[s[right]-'A']);
            int windowSize = right-left+1;
            if(windowSize - maxFreq > k){
                hash[s[left]-'A']--;
                left++;
            }
            windowSize = right-left+1;
            maxWindow = max(maxWindow,windowSize);
        }
        return maxWindow;
    }
};