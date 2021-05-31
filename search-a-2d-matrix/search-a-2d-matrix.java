class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < matrix[mid / matrix[0].length][mid % matrix[0].length]) {
                right = mid - 1;
            } else if (target == matrix[mid / matrix[0].length][mid % matrix[0].length]){
                return true;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}