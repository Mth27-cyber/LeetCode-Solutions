class Solution {
    public int maximumLengthSubstring(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                list.add(s.substring(i, j + 1));
            }
        }

        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            String a = list.get(i);
            HashMap<Character, Integer> map = new HashMap<>();
            boolean isValid = true;
            for (int j = 0; j < a.length(); j++) {
                char ch = a.charAt(j);
                int count = map.getOrDefault(ch, 0);
                if (count + 1 > 2) {
                    isValid = false;
                    break;
                }
                
                map.put(ch, count + 1);
            }
            if (isValid) {
                max = Math.max(max, a.length());
            }
        }
        
        return max;
    }
}