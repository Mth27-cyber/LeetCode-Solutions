class Solution {
    public int minimumDeletions(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
                map.put(nums[i], i);
            }
            if(nums[i] < min) {
                min = nums[i];
                map.put(nums[i], i);
            }
        }
        
        int n = nums.length;
        int idx1 = map.get(min);
        int idx2 = map.get(max);

        int first = Math.min(idx1, idx2);
        int second = Math.max(idx1, idx2);

        int bothFront = second + 1;
        int bothBack = n - first;
        int bothSides = (first + 1) + (n - second);

        return Math.min(bothFront, Math.min(bothBack, bothSides));
    }
}