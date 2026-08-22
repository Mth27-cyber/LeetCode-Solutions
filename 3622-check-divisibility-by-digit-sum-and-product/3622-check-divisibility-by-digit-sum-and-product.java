class Solution {
    public boolean checkDivisibility(int n) {
        int a = digitSum(n) + digitPro(n);
        if (a == 0) return false;
        
        return n % a == 0;
    }

    public int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public int digitPro(int n) {
        int pro = 1;
        while (n > 0) {
            pro *= (n % 10);
            n /= 10;
        }
        return pro;
    }
}