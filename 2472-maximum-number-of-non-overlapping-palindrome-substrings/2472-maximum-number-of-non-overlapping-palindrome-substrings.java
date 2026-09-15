class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int count = 0;
        int lastEnd = 0;

        int i = 0;
        while (i <= n - k) {

            if (i >= lastEnd && isPalindrome(s, i, i + k - 1)) {
                count++;
                lastEnd = i + k;
                i = lastEnd;
                continue;
            }

            if (i + k < n && i >= lastEnd && isPalindrome(s, i, i + k)) {
                count++;
                lastEnd = i + k + 1;
                i = lastEnd;
                continue;
            }

            i++;
        }

        return count;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}