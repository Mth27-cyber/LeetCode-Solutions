class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (int i = n - 1; i >= 0; i--) {
            int[] currentFreq = freq.clone();
            boolean possible = true;
            for (int k = 0; k < i; k++) {
                int charIdx = target.charAt(k) - 'a';
                if (currentFreq[charIdx] <= 0) {
                    possible = false;
                    break;
                }
                currentFreq[charIdx]--;
            }

            if (!possible) continue;

            int targetCharIdx = target.charAt(i) - 'a';
            int choice = -1;
            for (int c = targetCharIdx + 1; c < 26; c++) {
                if (currentFreq[c] > 0) {
                    choice = c;
                    break;
                }
            }
            if (choice != -1) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.substring(0, i));
                sb.append((char) ('a' + choice));
                currentFreq[choice]--;

              
                for (int c = 0; c < 26; c++) {
                    while (currentFreq[c] > 0) {
                        sb.append((char) ('a' + c));
                        currentFreq[c]--;
                    }
                }
                return sb.toString();
            }
        }

        return "";
    }
}