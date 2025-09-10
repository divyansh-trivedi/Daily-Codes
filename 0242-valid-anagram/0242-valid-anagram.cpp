class Solution {
public:
    bool isAnagram(string s, string t) {
        return multiset<char>(s.begin(), s.end()) == multiset<char>(t.begin(), t.end());
    }
};
