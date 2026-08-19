class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            if (col >= 2 && col <= 9) {
                map.computeIfAbsent(row, k -> new HashSet<>()).add(col);
            }
        }

        int count = 0;

        for (Set<Integer> set : map.values()) {
            boolean a = !set.contains(2) && !set.contains(3) && !set.contains(4) && !set.contains(5);
            boolean c = !set.contains(6) && !set.contains(7) && !set.contains(8) && !set.contains(9);
            boolean b = !set.contains(4) && !set.contains(5) && !set.contains(6) && !set.contains(7);

            if (a && c) {
                count += 2;
            } else if (a || b || c) {
                count += 1;
            }
        }

        count += (n - map.size()) * 2;

        return count;
    }
}