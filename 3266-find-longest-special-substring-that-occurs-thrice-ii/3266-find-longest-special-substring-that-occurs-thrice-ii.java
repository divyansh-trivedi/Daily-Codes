class Solution {
    public int maximumLength(String s) {
        int n=s.length();
        int matrix [][] = new int [26][n];

        for(int i=0;i<n;){
            char ch =s.charAt(i);
            int c=0;
            while (i < n && ch == s.charAt(i)) {
                matrix[ch - 'a'][c++]++;
                i++;
            }
        }
        int max=-1;
        for(int i=0;i<26;i++){
            int cs =0 ;
            for(int j=n-1;j>=0;j--){
                if(matrix[i][j]==0)continue;
                cs+=matrix[i][j];
                if(cs>=3){
                    max =Math.max(max , j+1);
                    break;
                } 
            }
        }

        return max;

        
    }
}