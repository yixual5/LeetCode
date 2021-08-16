class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        if (paths == null || paths.length == 0) return result;
        for (String path : paths) {
            String[] s = path.split(" ");
            for (int i = 1; i < s.length; i++) {
                String[] temp = s[i].split("\\(");
                map.computeIfAbsent(temp[1].substring(0, temp[1].length() - 1), k -> new ArrayList<>()).add(s[0] + "/" + temp[0]);
                
            }
        }
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                result.add(map.get(key));
            }
        }
        return result;
    }
}