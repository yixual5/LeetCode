class Solution {
    private int[] nums;
    private int k;
    
    public int findKthLargest(int[] nums, int k) {
        this.k = nums.length - k;
        this.nums = nums;
        return findK(0, nums.length - 1);
        
    }
    
    private int findK(int left, int right) {
        int rand_pivot = (int)  ((Math.random() * (right + 1 - left)) + left);
        int pivot = partition(left, right, rand_pivot);
        if (left == right) return this.nums[left];
        if (pivot == this.k) {
            return this.nums[pivot];
        } else if (pivot < this.k){
            
            return findK(pivot + 1, right);
            
        } else {
            
            return findK(left, pivot - 1);
        }
    }
    
    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private int partition(int left, int right, int pivot) {
        this.swap(pivot, right);
        for (int i = left; i < right; i++) {
            if (nums[i] < nums[right]) {
                this.swap(i, left++);
            }
        }
        this.swap(left, right);
        return left;
    }
}
