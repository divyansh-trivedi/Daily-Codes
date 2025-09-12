class Solution {
public:
    bool doesAliceWin(string s) {
        for (char c : s) {
            switch (tolower(c)) {
                case 'a': case 'e': case 'i': case 'o': case 'u':
                    return true;
            }
        }
        return false;
    }
};