class NumArray {
    int[] tree;
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        int height = (int) Math.ceil(Math.log(nums.length) / Math.log(2));
        tree = new int[(int)Math.pow(2, height + 1) - 1];
        constrct(0, 0, nums.length - 1);
    }
    
    private void constrct(int cur, int left, int right) {
        if (left == right) {
            tree[cur] = nums[left];
            return;
        }
        int mid = (right + left) >> 1;
        constrct(cur * 2 + 1, left, mid);
        constrct(cur * 2 + 2, mid + 1, right);
        tree[cur] = tree[cur * 2 + 1] + tree[cur * 2 + 2];
    }
    
    public void update(int index, int val) {
        update(val, 0, nums.length - 1, index, 0);
    }
    
    private void update(int value, int left, int right, int index, int cur) {
    
        if (left == right) {
            tree[cur] = value; 
            return;
        }
        int mid = (right + left) >> 1;
        if (index <= mid) update(value, left, mid, index, cur *2 + 1);
        else update(value, mid + 1, right, index, cur *2 + 2);
        tree[cur] = tree[cur *2 + 1] + tree[cur *2 + 2];
    }
    
    public int sumRange(int left, int right) {
        return sum(left, right, 0, nums.length - 1, 0);
    }
    
    private int sum(int left, int right, int cur_left, int cur_right, int cur) {
        if (cur_left > right || cur_right < left) return 0;
        if (cur_left >= left && cur_right <= right) return tree[cur];
        int mid = (cur_right + cur_left) >> 1;
        if (left > mid) return sum(left, right, mid + 1, cur_right, cur * 2 + 2);
        else if (right <= mid) return sum(left, right, cur_left, mid, cur * 2 + 1);
        return sum(left, mid, cur_left, mid, cur * 2 + 1) + sum(mid + 1, right, mid + 1, cur_right, cur * 2 + 2);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */