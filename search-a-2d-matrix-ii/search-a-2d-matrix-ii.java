class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int column = 0; // bottum-left
        while (row >= 0 && column < matrix[0].length) {
            if (target == matrix[row][column]) return true;
            if (target > matrix[row][column]) {
                column++;
            } else {
                row--;
            }
        }
        return false;
    }
}