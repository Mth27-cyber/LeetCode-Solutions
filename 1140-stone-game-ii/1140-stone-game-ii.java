class Solution {
    private Integer[][] memo; 

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        memo = new Integer[n][n + 1];
        
        int totalSum = 0;
        for (int pile : piles) {
            totalSum += pile;
        }
        
        int diff = dp(piles, 0, 1);
        
        return (totalSum + diff) / 2;
    }
    
    private int dp(int[] piles, int i, int M) {
        int n = piles.length;
        
        if (i >= n) return 0;
        
        if (memo[i][M] != null) {
            return memo[i][M];
        }
        
        int maxDiff = Integer.MIN_VALUE;
        int stonesTaken = 0; 
        
        for (int x = 1; x <= 2 * M && i + x - 1 < n; x++) {
            stonesTaken += piles[i + x - 1];
            int diff = stonesTaken - dp(piles, i + x, Math.max(M, x));
            maxDiff = Math.max(maxDiff, diff);
        }
        
        memo[i][M] = maxDiff;
        return maxDiff;
    }
}