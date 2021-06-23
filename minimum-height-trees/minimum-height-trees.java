class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n <= 2) {
            
            for (int i = 0; i < n; i++) {
                result.add(i);
            }
            return result;
        }
        int[] degree = new int[n];
        List<List<Integer>> ajList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ajList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            ajList.get(edge[0]).add(edge[1]);
            ajList.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) return result;
            if (degree[i] == 1) q.offer(i);
        }
        int count = n;
        while (count > 2) {
            int sz = q.size();
            List<Integer> leave = new ArrayList<>();
            count -= sz;
            for (int i = 0; i < sz; i++) {
                int temp = q.poll();
                
                degree[temp]--;
                for (Integer it : ajList.get(temp)) {
                    
                    if (degree[it] == 2) {
                        
                        q.offer(it);
                        leave.add(it);
                    } else if (degree[it] == 0) {
                        continue;
                    }
                    degree[it]--;
                }
                
            }
            result = leave;
        }
        return result;
        
    }
}