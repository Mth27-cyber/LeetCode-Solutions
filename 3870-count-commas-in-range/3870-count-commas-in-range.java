class Solution {
    public int countCommas(int n) {
       return count(n);
    }
    
    public int count(int n) {
       if (n < 1000) {
        return 0;
       }
       
       int c = count1(n);
       int cou = 0;
       
       for (int i = 4; i < c; i++) {
           int countOfNumbers = 9 * (int)Math.pow(10, i - 1);
           int commasPerNumber = (i - 1) / 3;
           cou += countOfNumbers * commasPerNumber;
       }
       
       int base = (int)Math.pow(10, c - 1);
       int a = (n - base + 1) * ((c - 1) / 3);

       return cou + a;
    }
    
    public int count1(int n) {
        int c = 0;
        while(n > 0) {
            c++;
            n = n / 10;
        }
        return c;
    }
}