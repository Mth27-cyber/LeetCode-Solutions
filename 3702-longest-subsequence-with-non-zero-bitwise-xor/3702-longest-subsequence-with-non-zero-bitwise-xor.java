class Solution {
    public int longestSubsequence(int[] nums) {
        int num = 0;
        boolean nz = false;
        for(int i=0;i<nums.length;i++){
            num ^= nums[i];
            if(nz == false && num != 0){
                nz= true;
            }
        }
        if(num == 0 && nz == true){
            return nums.length-1;
        }else if (num != 0){
            return nums.length;
        }else{
            return 0;
        }
    }
}