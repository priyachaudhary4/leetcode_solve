class Solution {
public:
    bool canForm(string &word, unordered_set<string> &dict) {
        int n = word.size();

        vector<bool> dp(n + 1, false);
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = (i == n ? 1 : 0); j < i; j++) {
                if (dp[j] && dict.count(word.substr(j, i - j))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
        sort(words.begin(), words.end(),
             [](const string &a, const string &b) {
                 return a.size() < b.size();
             });

        unordered_set<string> dict;
        vector<string> result;

        for (string &word : words) {
            if (!word.empty() && canForm(word, dict))
                result.push_back(word);

            dict.insert(word);
        }

        return result;
    }
};