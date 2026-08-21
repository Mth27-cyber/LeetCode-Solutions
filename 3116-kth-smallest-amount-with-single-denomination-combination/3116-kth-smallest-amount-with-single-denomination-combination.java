class Solution {
    public long findKthSmallest(int[] coins, int k) {
        // Step 1: Find the minimum coin to set the upper bound
        long minCoin = coins[0];
        for (int c : coins) {
            minCoin = Math.min(minCoin, c);
        }

        long low = 1;
        long high = minCoin * (long) k;
        long ans = high;

        // Step 2: Binary search on the answer value
        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (countMultiples(coins, mid) >= k) {
                ans = mid;
                high = mid - 1; // Try to find a smaller valid amount
            } else {
                low = mid + 1;  // Not enough multiples, look higher
            }
        }

        return ans;
    }

    // Step 3: Count numbers <= target divisible by at least one coin
    private long countMultiples(int[] coins, long target) {
        int n = coins.length;
        long totalCount = 0;

        // Bitmask from 1 to (2^n - 1) to generate all non-empty subsets
        for (int mask = 1; mask < (1 << n); mask++) {
            long currentLcm = 1;
            int bitCount = 0;
            boolean overflow = false;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bitCount++;
                    currentLcm = lcm(currentLcm, coins[i]);

                    // Optimization: If LCM exceeds target, target / LCM is 0
                    if (currentLcm > target) {
                        overflow = true;
                        break;
                    }
                }
            }

            if (!overflow) {
                long count = target / currentLcm;
                if (bitCount % 2 == 1) {
                    totalCount += count; // Add odd-sized subsets
                } else {
                    totalCount -= count; // Subtract even-sized subsets
                }
            }
        }

        return totalCount;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}