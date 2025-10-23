class Solution {
    public boolean hasSameDigits(String s) {
        if (s.length() < 2) return false;
        
        int i = 0;
        String temp = "";

        while (s.length() > 2) {
            temp = "";
            i = 0;
            
            while (i < s.length() - 1) {
                int a = s.charAt(i) - '0';
                int b = s.charAt(i + 1) - '0';
                int sum = (a + b) % 10;
                temp += sum;
                i++;
            }
            
            s = temp;
        }

        return s.charAt(0) == s.charAt(1);
    }
}
