class Solution {
    
    private static final int N = 1000000007;
    
    public int maxSum(int[] a, int[] b) { 
    
        int n = a.length, m = b.length;
        long sa = 0, sb = 0, ans = 0;
        int i = 0, j = 0;
        
        while (i < n && j < m) {
            
            if (a[i] < b[j]) {
                sa += a[i++];
            }
            else if (b[j] < a[i]) {
                sb += b[j++];
            }
            else {
                ans += a[i] + Math.max(sa, sb); 
                sa = 0; sb = 0; i++; j++; 
            }
        }
        
        while (i < n) sa += a[i++];
        while (j < m) sb += b[j++];
        
        ans +=  Math.max(sa, sb);
        return (int)(ans%N);
    }
}
