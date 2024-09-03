class Solution {
    public int getLucky(String s, int k) {
        String str = "";
        // Convert each character to its corresponding position in the alphabet
        for (int i = 0; i < s.length(); i++) {
            int num = (s.charAt(i) - 'a' + 1);
            str += num;
        }

        // Apply the transformation k times
        int sum = 0;
        while (k > 0) {
            sum = 0;
            for (char c : str.toCharArray()) {
                sum += c - '0'; // Convert character to digit and add to sum
            }
            str = Integer.toString(sum); // Convert the sum back to a string
            k--;
        }

        return sum;
    }
}
