// if after first round we back to origin, it means all movements are cancelled with each other, we will still back to origin in the future rounds, which result
// in a cycle. If after first round we point to north(0), we will keep move same amount as before. As long as we did not back to origin at the first round, we keep
// moving and never back. If we are 90 degree off from north, we are guaranteed back to origin in 4 rounds because we move same distance each round with
// different direction. After 4 rounds, we move same amount in each direction, which cancels each other - back to origin. if 180 degree off, we only need two rounds
// to check if in cycle or not, we can check whether back to origin or face to north.


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
