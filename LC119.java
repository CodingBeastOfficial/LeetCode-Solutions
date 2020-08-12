class Solution {
    public List<Integer> getRow(int k) {

        int n = k+1;
        int[] ans = new int[n];        
        ans[n-1] = 1;

        int i = n-2;
        while (i >= 0) {
            for (int j=i; j<n-1; j++) {
                ans[j] += ans[j+1];
            }
            i--;
        }

        List<Integer> res = new ArrayList<>(n);
        for (int a: ans) res.add(a);
        
        return res;
    }
}
