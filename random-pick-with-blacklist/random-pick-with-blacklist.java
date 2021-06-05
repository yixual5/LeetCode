class Solution {
    int remain;
    Random rand;
    int n;
    Map<Integer, Integer> hm;
    public Solution(int n, int[] blacklist) {
        this.rand = new Random();
        this.n = n;
        this.remain = n - blacklist.length;
        this.hm = new HashMap<>();
        Set<Integer> blk = new HashSet<>();
        for (int i = this.remain; i < n; i++) {
            blk.add(i);
        }
        for (int b: blacklist) {
            blk.remove(b);
        }
        int i = 0;
        for (int j: blk) {
            while (i < blacklist.length) {
                if (blacklist[i] < this.remain) {
                    this.hm.put(blacklist[i], j);
                    i++;
                    break;
                }
                i++;
            }
        }
        

    }
    
    public int pick() {
        int r = rand.nextInt(this.remain);
        if (this.hm.containsKey(r)) {
            return this.hm.get(r);
        } else {
            return r;
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */