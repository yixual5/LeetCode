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

// change stack to two array, keep the left smaller and right smaller
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] hist = new int[matrix[0].length];
        int[] leftsmaller = new int[matrix[0].length];
        int[] rightsmaller = new int[matrix[0].length];
        Arrays.fill(rightsmaller, matrix[0].length);
        int max = 0;
        leftsmaller[0] = -1;
        for (int i = 0; i < matrix.length; i++) {
            int curleft = -1, curright = matrix[0].length;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') hist[j] = 0;
                else hist[j] += 1;
            }
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') leftsmaller[j] = Math.max(leftsmaller[j], curleft);
                else {
                    curleft = j;
                    leftsmaller[j] = -1;
                }
            }
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') rightsmaller[j] = Math.min(rightsmaller[j], curright);
                else {
                    curright = j;
                    rightsmaller[j] = matrix[0].length;
                }
            }
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, hist[j] * (rightsmaller[j] - leftsmaller[j] - 1));
            }
        }
        return max;
    }
}
