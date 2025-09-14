class Solution {
private:
    string noVowel(const string& s) {
        string res;
        res.reserve(s.size());
        for(char c : s) {
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
                res.push_back('*');
            else
                res.push_back(c);
        }
        return res;
    }

public:
    vector<string> spellchecker(vector<string>& wordlist, vector<string>& queries) {
        vector<string> ans(queries.size());

        unordered_set<string> exact(wordlist.begin(), wordlist.end());
        unordered_map<string,string> cap;
        unordered_map<string,string> vow;

        for(string& w : wordlist) {
            string low = w;
            transform(low.begin(), low.end(), low.begin(), ::tolower);

            if(!cap.count(low)) cap[low] = w;
            string mask = noVowel(low);
            if(!vow.count(mask)) vow[mask] = w;
        }

        for(int i=0; i<queries.size(); i++) {
            string q = queries[i];
            if(exact.count(q)) {
                ans[i] = q;
                continue;
            }

            string low = q;
            transform(low.begin(), low.end(), low.begin(), ::tolower);
            if(cap.count(low)) {
                ans[i] = cap[low];
                continue;
            }

            string mask = noVowel(low);
            if(vow.count(mask)) {
                ans[i] = vow[mask];
                continue;
            }

            ans[i] = "";
        }

        return ans;
    }
};
