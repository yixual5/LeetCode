class Solution {
    private int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public boolean isRobotBounded(String instructions) {
        if (instructions == null || instructions.length() == 0) return true;
        char[] instrc = instructions.toCharArray();
        int curd = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < instrc.length; i++) {
            if (instrc[i] == 'G') {
                x += dir[curd][0];
                y += dir[curd][1];
            } else if (instrc[i] == 'R') {
                curd = (curd + 1) % 4;
            } else {
                curd = (curd + 3) % 4;
            }
        }
        return curd != 0 || (x == 0 && y == 0);
    }
}