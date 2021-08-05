class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                String[] s1_part = s1.split(" ", 2);
                String[] s2_part = s2.split(" ", 2);
                if (!isNumeric(s1_part[1]) && !isNumeric(s2_part[1])) {
                    if (s1_part[1].equals(s2_part[1])) {
                        return s1_part[0].compareTo(s2_part[0]);
                    }
                    return s1_part[1].compareTo(s2_part[1]);
                } else if (isNumeric(s1_part[1]) && isNumeric(s2_part[1])) {
                    return 0;
                } else if (isNumeric(s1_part[1])) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        return logs;
    }
    
    public boolean isNumeric(String s) {
        return Character.isDigit(s.charAt(0));
    }
}