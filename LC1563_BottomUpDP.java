class Solution {
    
    public int stoneGameV(int[] s) {
        
        int n = s.length;
        int[] prefix = new int[n];
        
        prefix[0] = s[0];
        for (int i=1; i<n; i++) prefix[i] = prefix[i-1] + s[i];
        
        int[][] dp = new int[n][n];
        
        for (int len=1; len<=n; len++) {
            
            for (int l=0; l+len-1 < n; l++) {
                int r = l+len-1;
                for (int i=l; i<r; i++) {
                    
                    int lsum = prefix[i] - prefix[l] + s[l];
                    int rsum = prefix[r] - prefix[i];
                    
                    if (lsum < rsum) dp[l][r] = Math.max(dp[l][r], lsum + dp[l][i]);
                    else if (rsum < lsum) dp[l][r] = Math.max(dp[l][r], rsum + dp[i+1][r]);
                    else dp[l][r] = Math.max(dp[l][r], lsum + Math.max(dp[l][i], dp[i+1][r]));
                }
            }
        }
        
        return dp[0][n-1];
    }
}
