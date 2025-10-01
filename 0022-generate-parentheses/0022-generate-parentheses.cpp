class Solution {
private:
    bool isPossible(string& s) {
        int open = 0;
        int close = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(')
                open++;
            else
                close++;
            if (close > open)
                return false;
        }
        open = 0;
        close = 0;
        for (int i = s.size() - 1; i >= 0; i--) {
            if (s[i] == '(')
                open++;
            else
                close++;
            if (open > close)
                return false;
        }
        return true;
    }

private:
    void solve(int n, vector<string>& vec, string temp) {
        if (n == 0) {
            if (isPossible(temp))
                vec.push_back(temp);
            return;
        }
        solve(n - 1, vec, temp + '(');
        solve(n - 1, vec, temp + ')');
    }

public:
    vector<string> generateParenthesis(int n) {
        vector<string> vec;
        solve(2 * n, vec, "");
        return vec;
    }
};