class Solution {
    public int minOperations(int[][] grid, int x) {
        int[] flat = new int[grid.length * grid[0].length];
        int k = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                flat[k++] = grid[i][j];
            }
        }
        int mid = (k - 1) / 2;
        Arrays.sort(flat);
        //quickSelect(mid, 0, k - 1, flat);
        int median = flat[mid];
        int res = 0;
        for (int num : flat) {
            int dif = Math.abs(num - median);
            if (dif % x != 0) return -1;
            res += dif / x;
        }
        return res;
    }
    
    private void quickSelect(int k, int left, int right, int[] flat) {
        if (left == right) return;
        Random random_num = new Random();
        int pivot = left + random_num.nextInt(right - left);
        int cur_pivot = partition(left, right, right, flat);
        if (cur_pivot == k) return;
        else if (cur_pivot < k) quickSelect(k, cur_pivot + 1, right, flat);
        else quickSelect(k, left, cur_pivot - 1, flat);
    }
    
    private void swap(int[] flat, int x, int y) {
        int temp = flat[x];
        flat[x] = flat[y];
        flat[y] = temp;
    }
    
    private int partition(int left, int right, int pivot, int[] flat) {
        swap(flat, pivot, right);
        int cur_pivot = left;
        for (int i = left; i < right; i++) {
            if (flat[i] < flat[right]) swap(flat, i, cur_pivot++);
        }
        swap(flat, cur_pivot, right);
        return cur_pivot;
    }
}