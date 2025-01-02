class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int max = -1;
        int ans[] = new int [queries.length];
        
        int arr[] = new int[words.length + 1]; 
        Arrays.fill(arr,0);

        for (int i = 0; i < words.length; i++) {
            char ch1 = words[i].charAt(0);
            char ch2 = words[i].charAt(words[i].length() - 1);
            if ((ch1 == 'a' || ch1 == 'e' || ch1 == 'i' || ch1 == 'o' || ch1 == 'u') &&
                (ch2 == 'a' || ch2 == 'e' || ch2 == 'i' || ch2 == 'o' || ch2 == 'u')) {
                arr[i + 1] = arr[i] + 1; 
            } else {
                arr[i + 1] = arr[i]; 
            }
        }
        int k = 0;
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            ans[k++] = arr[r + 1] - arr[l];
        }

        return ans;
    }
}