class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                nums[i] = Math.abs(nums[i]);
            }
        }
          long res= 0;
        Arrays.sort(nums);
        int m = nums.length/2;
        for(int i=0;i<m;i++){
            res -= (long)nums[i]*nums[i];
        }
        for(int i=m;i<nums.length;i++){
            res += (long)nums[i]*nums[i];
        }
        return res;
    }
}