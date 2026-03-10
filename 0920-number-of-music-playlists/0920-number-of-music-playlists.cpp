class Solution {
public:
    int numMusicPlaylists(int n, int goal, int k) {
        const long MOD = 1000000007;
        vector<vector<long>> dp(goal+1, vector<long>(n+1,0));
        
        dp[0][0] = 1;

        for(int i=1;i<=goal;i++){
            for(int j=1;j<=n;j++){

                // add new song
                dp[i][j] += dp[i-1][j-1] * (n-(j-1));
                dp[i][j] %= MOD;

                // replay old song
                if(j>k){
                    dp[i][j] += dp[i-1][j] * (j-k);
                    dp[i][j] %= MOD;
                }
            }
        }

        return dp[goal][n];
    }
};