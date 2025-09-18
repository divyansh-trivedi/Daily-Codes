class Solution {
public:
    string minWindow(string s, string t) {
        if (t.size() > s.size() || t.empty()) {
            return "";
        }

        vector<int> map(128, 0);
        for (char c : t) {
            map[c]++;
        }

        int left = 0;
        int min_len = -1;
        int start_index = -1;
        int required = t.length();

        for (int right = 0; right < s.size(); right++) {
            if (map[s[right]] > 0) {
                required--;
            }
            map[s[right]]--;

            while (required == 0) {
                if (min_len == -1 || right - left + 1 < min_len) {
                    min_len = right - left + 1;
                    start_index = left;
                }

                map[s[left]]++;
                if (map[s[left]] > 0) {
                    required++;
                }
                
                left++;
            }
        }

        return (start_index == -1) ? "" : s.substr(start_index, min_len);
    }
};