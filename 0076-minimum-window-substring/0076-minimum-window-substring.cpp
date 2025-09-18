class Solution {
private:
    // Your check function is perfectly fine!
    bool check(vector<int>& hash_window, vector<int>& hash_t){
        for(int i=0; i<128; i++)
            if(hash_window[i] < hash_t[i]) return false;
        return true;
    }

public:
    string minWindow(string s, string t) {
        // Basic check: if t is longer than s, no solution is possible.
        if (t.size() > s.size()) return "";

        // hash_t stores the character counts needed by string t.
        vector<int> hash_t(128, 0);
        for(char c : t) hash_t[c]++;

        // hash_window will store character counts for our current sliding window.
        vector<int> hash_window(128, 0);
        
        int left = 0;
        int min_len = -1;
        int start_index = -1;

        // Use a 'right' pointer to expand the window.
        for (int right = 0; right < s.size(); right++) {
            // Add the new character to our window's hash map.
            hash_window[s[right]]++;

            // While the current window is valid (has all chars from t)...
            while (left <= right && check(hash_window, hash_t)) {
                // Check if this valid window is the shortest one we've found so far.
                if (min_len == -1 || right - left + 1 < min_len) {
                    min_len = right - left + 1;
                    start_index = left;
                }

                // ...try to make the window smaller by shrinking from the left.
                hash_window[s[left]]--;
                left++;
            }
        }

        return (start_index == -1) ? "" : s.substr(start_index, min_len);
    }
};