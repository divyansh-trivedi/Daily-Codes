class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char c1[] = s1.toCharArray();
        Arrays.sort(c1);
        String str1 = new String(c1);
        int len = c1.length;
        for (int i = 0; i <= s2.length() - len; i++) {
            char c2[] = s2.substring(i, i + len).toCharArray();
            Arrays.sort(c2);
            String str2 = new String(c2);
            if (str1.equals(str2))
                return true;
        }
        return false;
    }
}