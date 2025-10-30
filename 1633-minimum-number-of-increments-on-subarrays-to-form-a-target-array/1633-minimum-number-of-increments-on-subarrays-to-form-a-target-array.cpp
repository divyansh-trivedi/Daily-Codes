class Solution {
public:
    int minNumberOperations(vector<int>& target) {
        
        int cnt=target[0];

        int n = target.size();

        for(int i=1;i<n;i++)
        {
             if(target[i-1]<target[i]) cnt += abs(target[i]-target[i-1]);  
        }
        return cnt;
    }
};