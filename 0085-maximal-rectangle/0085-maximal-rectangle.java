import java.util.*;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int n = matrix.length, m = matrix[0].length;
        int maxArea = 0;
        int[] height = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                height[j] = matrix[i][j] == '1' ? height[j] + 1 : 0;
            }
            int ans = largestRectangleArea(height);
            maxArea = Math.max(maxArea, ans);
        }
        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            leftSmall[i] = st.isEmpty() ? 0 : st.peek() + 1;
            st.push(i);
        }

        while (!st.isEmpty()) st.pop();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            rightSmall[i] = st.isEmpty() ? n - 1 : st.peek() - 1;
            st.push(i);
        }

        int maxA = 0;
        for (int i = 0; i < n; i++) {
            maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
        }
        return maxA;
    }
}

