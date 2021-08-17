// Union find
class Solution {
    int[] parent;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        parent = new int[accounts.size()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        Map<String, Integer> emailToId = new HashMap<>();
        int id = 0;
        for (int i = 0; i < accounts.size(); i++) {
            List<String> emailList = accounts.get(i);
            for (int j = 1; j < emailList.size(); j++) {
                if (!emailToId.containsKey(emailList.get(j))) emailToId.put(emailList.get(j), i);
                else union(i, emailToId.get(emailList.get(j)));
            }
        }
        List<List<String>> result = new ArrayList<>();
        //for (int i = 0; i < accounts.size(); i++) result.add(new ArrayList<>());
        Map<Integer, Integer> cluster = new HashMap<>();
        int idx = 0;
        for (String email : emailToId.keySet()) {
            int eid = find(emailToId.get(email));
            if (!cluster.containsKey(eid)) {
                cluster.put(eid, idx);
                List<String> temp = new ArrayList<>();
                temp.add(email);
                result.add(temp);
                idx++;
            } else {
                result.get(cluster.get(eid)).add(email);
            }
        }
        result.forEach(k -> Collections.sort(k));
        for (List<String> i : result) {
            i.add(0, accounts.get(emailToId.get(i.get(0))).get(0));
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
