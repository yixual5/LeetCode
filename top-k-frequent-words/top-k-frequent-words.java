class Solution {
    // implement quick select
    HashMap<String, Integer> count;
    String[] st;
    public List<String> topKFrequent(String[] words, int k) {
        this.count = new HashMap<>();
        for (String s: words) {
            count.compute(s, (key, val) -> val == null ? 1 : val + 1);
        }
        this.st = new String[count.size()];
        int i = 0;
        for (String s : count.keySet()) {
            st[i++] = s;
        }
        this.quickSelect(st.length - k, 0, st.length - 1);
        Arrays.sort(st, st.length - k, st.length, ((a,b) -> count.get(a) - count.get(b) != 0 ? count.get(b) - count.get(a) : a.compareTo(b)));
        return Arrays.asList(Arrays.copyOfRange(st, st.length - k, st.length));
    }
    
    private void quickSelect(int k, int left, int right) {
        
        if (left == right) return;
        Random random_num = new Random();
        int pivot_index = left + random_num.nextInt(right - left);
        int cur_pivt = partition(left, right, pivot_index);
        if (cur_pivt < k) {
            quickSelect(k, cur_pivt + 1, right);
        } else if (cur_pivt == k) {
            return;
        } else {
            quickSelect(k, left, cur_pivt - 1);
        }
        
    }
    
    private void swap (int a, int b) {
        String temp = st[a];
        st[a] = st[b];
        st[b] = temp;
    }
    
    private int compareTwoString (int a, int b) {
        int freqa = count.get(st[a]);
        int freqb = count.get(st[b]);
        if (freqa < freqb) return -1;
        //if (freqa > freqb) return 1;
        if (freqa == freqb) {
            return st[b].compareTo(st[a]);
        }
        return 1;
    }
    
    private int partition (int left, int right, int pivot) {
        this.swap(pivot, right);
        for (int i = left; i <= right; i++) {
            if (compareTwoString(i, right) < 0) {
                this.swap(left++, i);
            }
        }
        this.swap(left, right);
        return left;
    }
}