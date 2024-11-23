class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length; // Number of rows
        int n = box[0].length; // Number of columns
        
        // Step 1: Move stones ('#') to the bottom of each row due to gravity
        for (int row = 0; row < m; row++) {
            int emptySpot = n - 1; // Start checking from the right end
            for (int col = n - 1; col >= 0; col--) {
                if (box[row][col] == '*') {
                    // Reset emptySpot to the left of the obstacle
                    emptySpot = col - 1;
                } else if (box[row][col] == '#') {
                    // Move stone to the lowest available spot
                    box[row][col] = '.';
                    box[row][emptySpot] = '#';
                    emptySpot--;
                }
            }
        }
        
        // Step 2: Rotate the box 90 degrees clockwise
        char[][] rotatedBox = new char[n][m];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                rotatedBox[col][m - 1 - row] = box[row][col];
            }
        }
        
        return rotatedBox;
    }
}
