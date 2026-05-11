class Solution {
public:
    vector<string> result;

    void backtrack(string s, int start, vector<string>& path) {

        // If 4 parts are created
        if (path.size() == 4) {

            // All characters must be used
            if (start == s.length()) {

                string ip = path[0] + "." + path[1] + "." +
                            path[2] + "." + path[3];

                result.push_back(ip);
            }
            return;
        }

        // Try segment lengths 1 to 3
        for (int len = 1; len <= 3; len++) {

            if (start + len > s.length())
                break;

            string part = s.substr(start, len);

            // Leading zero check
            if (part.length() > 1 && part[0] == '0')
                continue;

            // Convert to integer
            int num = stoi(part);

            // Range check
            if (num <= 255) {

                path.push_back(part);

                backtrack(s, start + len, path);

                path.pop_back();
            }
        }
    }

    vector<string> restoreIpAddresses(string s) {

        vector<string> path;

        backtrack(s, 0, path);

        return result;
    }
};