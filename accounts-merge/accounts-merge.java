// Union find
class Solution {
    int[] parent = new int[10001];
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Integer> emailToId = new HashMap<>();
        int id = 0;
        for (List<String> s : accounts) {
            String name = s.remove(0);
            for (String email : s) {
                emailToName.put(email, name);
                if (!emailToId.containsKey(email)) emailToId.put(email, id++);
                union(emailToId.get(s.get(0)), emailToId.get(email));
            }
        }
        Map<Integer, List<String>> cluster = new HashMap<>();
        for (String email : emailToId.keySet()) {
            cluster.computeIfAbsent(find(emailToId.get(email)), k -> new ArrayList<>()).add(email);
        }
        List<List<String>> result = new ArrayList<>();
        for (Integer i : cluster.keySet()) {
            List<String> temp = cluster.get(i);
            Collections.sort(temp);
            temp.add(0, emailToName.get(temp.get(0)));
            result.add(temp);
        }
        return result;
    }
    
    private int find(int id) {
        return parent[id] != id ? find(parent[id]) : id;
    }
    
    private void union(int id1, int id2) {
        parent[find(id1)] = find(id2);
    }
}