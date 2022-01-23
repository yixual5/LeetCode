class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair<Integer, String>>> userInfo = new HashMap<>();
        
        for (int i = 0; i < username.length; i++) {
            Pair<Integer, String> p = new Pair(timestamp[i], website[i]);
            userInfo.computeIfAbsent(username[i], k -> new ArrayList<Pair<Integer, String>>()).add(p);
        }
        Map<String, Integer> count = new HashMap<>();
        String res = "";
        for (String user : userInfo.keySet()) {
            List<Pair<Integer, String>> temp = userInfo.get(user);
            Set<String> patterns = new HashSet<>();
            Collections.sort(temp, (a1, a2) -> a1.getKey() - a2.getKey());
            if (temp.size() < 3) continue;
            for (int i = 0; i < temp.size() - 2; i++) {
                for (int j = i + 1; j < temp.size() - 1; j++) {
                    for (int k = j + 1; k < temp.size(); k++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(temp.get(i).getValue()).append(",").append(temp.get(j).getValue()).append(",").append(temp.get(k).getValue());
                        String pattern = sb.toString();
                        if (patterns.contains(pattern)) continue;
                        else {
                            patterns.add(pattern);
                            count.put(pattern, count.getOrDefault(pattern, 0) + 1);
                            if (count.getOrDefault(res, 0) < count.get(pattern) || (count.get(pattern) == count.get(res) && res.compareTo(pattern) > 0)) res = pattern;
                        }
                    } 
                }
            }
        }
        return Arrays.asList(res.split(","));
    }
}