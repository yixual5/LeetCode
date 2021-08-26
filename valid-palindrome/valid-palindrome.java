class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            left++;
            right--;
        }
        return true;
    }
}

//java8 stream
class Solution {
    public boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        s.chars()
            .filter(c -> Character.isLetterOrDigit(c))
            .mapToObj(c -> Character.toLowerCase((char) c))
            .forEach(sb::append);
        return sb.toString().equals(sb.reverse().toString());
    }
}
