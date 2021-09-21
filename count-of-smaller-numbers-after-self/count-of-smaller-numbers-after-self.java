class Solution {
    private int[] tree;
    private int[] nums;
    public List<Integer> countSmaller(int[] nums) {
        int height = (int) Math.ceil(Math.log(20001) / Math.log(2));
        tree = new int[(int) Math.pow(2, height + 1) - 1];
        int offset = 10000;
        this.nums = nums;
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            result.addFirst(query(0, nums[i] + offset - 1, 0, 0, 20000));
            update(nums[i] + offset, 0, 20000, 0);
        }
        return (List) result;
    }
    
    private void update(int idx, int left, int right, int cur) {
        if (left == right) {
            tree[cur] += 1;
            return;
        }
        
        int mid = left + (right - left) / 2;
        if (idx <= mid) {
            update(idx, left, mid, cur * 2 + 1);
        } else {
            update(idx, mid + 1, right, cur * 2 + 2);
        }
        tree[cur] = tree[cur * 2 + 1] + tree[cur * 2 + 2];
    }
    
    private int query (int left, int right, int cur, int cur_left, int cur_right) {
        if (cur_right < left || right < cur_left) return 0;
        if (left <= cur_left && cur_right <= right) return tree[cur];
        
        int mid = cur_left + (cur_right - cur_left) / 2;
        
        if (mid < left) {
            return query(left, right, cur * 2 + 2, mid + 1, cur_right);
        } else if (mid >= right) {
            return query(left, right, cur * 2 + 1, cur_left, mid);
        }
        
        return query(mid + 1, right, cur * 2 + 2, mid + 1, cur_right) + query(left, mid, cur * 2 + 1, cur_left, mid);
        
    }
    
}