class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                String[] temp1 = s1.split(" ", 2);
                String[] temp2 = s2.split(" ", 2);
                String header1 = temp1[0].substring(0, temp1[0].length() - 1);
                String header2 = temp2[0].substring(0, temp2[0].length() - 1);
                if (!Character.isDigit(temp1[1].charAt(0))) {
                    if (!Character.isDigit(temp2[1].charAt(0))) {
                        if (temp1[1].equals(temp2[1])) return temp1[0].compareTo(temp2[0]);
                        else return temp1[1].compareTo(temp2[1]);
                    } else {
                        return -1;
                    }
                } else {
                    if (!Character.isDigit(temp2[1].charAt(0))) return 1;
                    else return 0;
                }
            }
        });
        return logs;
    }
}