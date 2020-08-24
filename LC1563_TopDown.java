class Solution {
    
    private int n;
    private int[] s;
    private int[] prefix;
    
    private int[][] dp;
    
    public int stoneGameV(int[] s) {
        
        this.s = s;
        n = s.length;
        prefix = new int[n];
        
        prefix[0] = s[0];
        for (int i=1; i<n; i++) prefix[i] = prefix[i-1] + s[i];
        
        dp = new int[n][n];
        for (int r=0; r<n; r++) {
            for (int c=0; c<n; c++) {
                dp[r][c] = -1;
            }
        }
        
        return exp(0, s.length-1);
    }
    
    private int exp(int l, int r) {
        
        if (l == r) return 0;
        
        if (dp[l][r] != -1) return dp[l][r];
        
        int score = 0;
        
        for (int i=l; i<r; i++) {
            
            int lsum = prefix[i] - prefix[l] + s[l];
            int rsum = prefix[r] - prefix[i];
            
            if (lsum < rsum) score = Math.max(score, lsum + exp(l,i));
            else if (rsum < lsum) score = Math.max(score, rsum + exp(i+1, r));
            else score = Math.max(score, Math.max(lsum + exp(l,i), rsum + exp(i+1,r)));
        }
        
        return dp[l][r] = score;
    }
}
