class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null) return result;
        int layer = 1;
        int w = matrix[0].length - 1;
        int h = matrix.length - 1;
        int starth = 0;
        int startw = 0;
        while (starth <= h && startw <= w) {
            for (int i = startw; i <= w; i++) {
                result.add(matrix[starth][i]);
            }
            for (int i = starth + 1; i <= h; i++) {
                result.add(matrix[i][w]);
            }
            
            if (starth < h && startw < w) {
                for (int i = w - 1; i > startw; i--) {
                    result.add(matrix[h][i]);
                }
                for (int i = h; i > starth; i--) {
                    result.add(matrix[i][startw]);
                }
            }
            starth++;
            startw++;
            w--;
            h--;
        }
        return result;
    }
}