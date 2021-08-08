class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<>();
        if (cpdomains == null || cpdomains.length == 0) return result;
        Map<String, Integer> count = new HashMap<>();
        for (String s : cpdomains) {
            String[] temp = s.split(" ");
            String[] temp2 = temp[1].split("\\.");
            int val = Integer.valueOf(temp[0]);
            String cur = "";
            for (int i = temp2.length - 1; i >= 0; i--) {
                if (i == temp2.length - 1) {
                    cur = temp2[i];
                } else {
                    cur = temp2[i] + "." + cur;
                }
                count.put(cur, count.getOrDefault(cur, 0) + val);
            }
        }
        for (String s : count.keySet()) {
            result.add(count.get(s) + " " + s);
        }
        return result;
    }
}