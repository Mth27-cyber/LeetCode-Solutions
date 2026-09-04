class Solution {
    public int firstStableIndex(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list.add(nums[0]);
        for(int i = 0 ; i < nums.length ; i++){
            list2.add(nums[i]);
        }
        
        for(int i = 0 ; i < nums.length ; i++){
            int max = max(list);
            int min = min(list2);
            int a = max - min;
            if (a <= k) {
                return i;
            }
            
            if (i < nums.length - 1) {
                list.add(nums[i+1]);
                list2.remove(0); 
            }
        }
        
        return -1;
    }
    
    public int max(ArrayList<Integer> list){
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < list.size() ; i++){
            if(list.get(i) > max){
                max = list.get(i);
            }
        }
        return max;
    }
    
    
    public int min(ArrayList<Integer> list){
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < list.size() ; i++){
            if(list.get(i) < min){
                min = list.get(i);
            }
        }
        return min;
    }
}