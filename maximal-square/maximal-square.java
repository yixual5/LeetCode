class Solution {
    public int maximalSquare(char[][] matrix) {
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
                int w = Math.min(rightsmaller[j] - leftsmaller[j] - 1, hist[j]);
                max = Math.max(max, w * w);
            }
        }
        return max;
    }
}