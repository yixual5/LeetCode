//bfs, O(n)
class Solution {
    int n;
    public int snakesAndLadders(int[][] board) {
        n = board.length;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int step = 0;
        boolean[] visited = new boolean[n * n + 1];
        visited[1] = true;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int num = q.poll();
                int[] next = getIdx(num, board);
                for (int j = 0; j < next.length; j++) {
                    if (next[j] == n * n) return step + 1;
                    if (!visited[next[j]]) {
                        visited[next[j]] = true;
                        q.offer(next[j]);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    
    private int[] getIdx(int num, int[][] board) {
        int max = Math.min(num + 6, n * n);
        int[] result = new int[max - num];
        for (int i = num + 1; i <= max; i++) {
            int row = n - 1 - (i - 1) / n;
            int col = (n - row) % 2 != 0 ? i - (n - row - 1) * n - 1 : n * (n - row) - i;
            if (board[row][col] != -1) {
                result[i - num - 1] = board[row][col];
            } else {
                result[i - num - 1] = i;
            }
        }
        return result;
    }
}
