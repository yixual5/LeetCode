class Solution {
    private int count;
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, LinkedList<String>> map = new HashMap<>();
        for (List<String> dest : tickets) {
            map.computeIfAbsent(dest.get(0), k -> new LinkedList<>()).add(dest.get(1));
        }
        map.forEach((k,v) -> Collections.sort(v));
        LinkedList<String> result = new LinkedList<>();
        dfs("JFK", map, result);
        return result;
    }
    
    private void dfs(String origin, Map<String, LinkedList<String>> map, LinkedList<String> result) {
        if (map.containsKey(origin)) {
            LinkedList<String> temp = map.get(origin);
            while (!temp.isEmpty()) {
                dfs(temp.pollFirst(), map, result);
            }
        }
        result.offerFirst(origin);
    }
}