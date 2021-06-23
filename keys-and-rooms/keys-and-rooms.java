// iterative dfs
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) return false;
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        Stack<Integer> cur = new Stack<>();
        cur.push(0);
        
        while (!cur.isEmpty()) {
            int temp = cur.pop();
            for (Integer i : rooms.get(temp)) {
                if (visited[i]) continue;
                cur.push(i);
                visited[i] = true;
            }
        }
        
        for (boolean b : visited) {
            if (!b) return false;
        }
        return true;
    }
}
