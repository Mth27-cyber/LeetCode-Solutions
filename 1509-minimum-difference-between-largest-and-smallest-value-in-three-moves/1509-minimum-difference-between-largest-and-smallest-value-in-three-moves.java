import java.util.Arrays;

class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4) return 0;

        Arrays.sort(nums);

        int opt1 = nums[n - 4] - nums[0];
        int opt2 = nums[n - 3] - nums[1];
        int opt3 = nums[n - 2] - nums[2];
        int opt4 = nums[n - 1] - nums[3];

        return Math.min(Math.min(opt1, opt2), Math.min(opt3, opt4));
    }
}