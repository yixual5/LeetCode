class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] hist = new int[matrix[0].length];
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') hist[j] = 0;
                else hist[j] += 1;
                while (s.peek() != -1 && hist[s.peek()] >= hist[j]) {
                    int cur = hist[s.pop()];
                    max = Math.max(max, (j - s.peek() - 1) * cur);
                }
                s.push(j);
            }
            while (s.peek() != -1) {
                int cur = hist[s.pop()];
                max = Math.max(max, cur * (matrix[0].length - s.peek() - 1));
            }
        }
        return max;
    }
}