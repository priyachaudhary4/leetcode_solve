class Solution {
    public int countVowelStrings(int n) {
        int[] dp = {1,1,1,1,1};
        for(int i = 1; i < n; i++){
            for(int j = 3; j >= 0; j--){
                dp[j] = dp[j] + dp[j + 1];
            }
        }
        int sum = 0; 
        for(int x: dp) sum += x;
        return sum ;
    }
};